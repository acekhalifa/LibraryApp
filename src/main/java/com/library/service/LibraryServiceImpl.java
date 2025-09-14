package com.library.service;

import com.library.entities.Book;
import com.library.entities.BookCopy;
import com.library.entities.BookRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class LibraryServiceImpl implements LibraryService{
    private static final Logger logger = LogManager.getLogger(LibraryServiceImpl.class);
    private final Map<String, Book> books;
    private final Map<String, List<BookCopy>> bookCopies;
    private final Map<String, PriorityQueue<BookRequest>> requestQueue;
    private final Map<String, BookCopy> totalCopies;

    public LibraryServiceImpl() {
        bookCopies = new HashMap<>();
        books = new HashMap<>();
        requestQueue = new HashMap<>();
        totalCopies = new HashMap<>();
    }

    public void addBook(Book book, int copies) {
        if (book == null){
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (copies < 1){
            throw new IllegalArgumentException("copies must at least one or higer");
        }
        books.put(book.getIsbn(), book);
        bookCopies.computeIfAbsent(book.getIsbn(), k -> new ArrayList<>());

        for (int i = 1; i <= copies; i++){
            String copyId = book.getIsbn() + "-" + i;
            var copy = new BookCopy(copyId, book.getTitle(), book.getAuthor());
            bookCopies.get(book.getIsbn()).add(copy);
            totalCopies.put(copyId,copy);
        }
        logger.info("Added {} copies of book: {}", copies, book);
    }

    public String borrowBook(BookRequest bookRequest) {
        if (bookRequest.getUser() == null || bookRequest.getBookId() == null) {
            throw new IllegalArgumentException("User and book ISBN cannot be null");
        }

        if (!books.containsKey(bookRequest.getBookId())) {
            logger.warn("Book not found: {}", bookRequest.getBookId());
            return "book not found";
        }

        // Check for available copy
        List<BookCopy> copies = bookCopies.get(bookRequest.getBookId());
        Optional<BookCopy> availableCopy = copies.stream()
                .filter(BookCopy::isAvailable)
                .findFirst();

        if (availableCopy.isPresent()) {
            BookCopy copy = availableCopy.get();
            copy.borrowTo(bookRequest.getUser());
            logger.info("Book borrowed successfully: {} by {} {}", copy,
                    bookRequest.getUser().getFirstName(), bookRequest.getUser().getLastName());
            return copy.getCopyId();
        } else {

            requestQueue.computeIfAbsent(bookRequest.getBookId(), k -> new PriorityQueue<>());
            BookRequest request = new BookRequest(bookRequest.getUser(), bookRequest.getBookId());
            requestQueue.get(bookRequest.getBookId()).add(request);
            logger.info("Book request queued: {}", request);
            return "book taken";
        }
    }

    public boolean returnBook(String bookId) {
        return false;
    }


    public Map<String, BookCopy> getTotalCopies() {
        return totalCopies;
    }
}

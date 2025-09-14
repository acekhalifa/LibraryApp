package com.library.service;

import com.library.entities.Book;
import com.library.entities.BookCopy;
import com.library.entities.BookRequest;

import java.util.Map;

public interface LibraryService {
    void addBook(Book book, int copies);
    String borrowBook(BookRequest bookRequest);
    boolean returnBook(String bookId);
    Map<String, BookCopy> getTotalCopies();
}

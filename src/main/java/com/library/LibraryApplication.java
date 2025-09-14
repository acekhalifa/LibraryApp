// src/main/java/com/library/LibraryApplication.java
package com.library;

import com.library.entities.*;
import com.library.service.LibraryService;
import com.library.service.LibraryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main application demonstrating the Library Management System
 */
public class LibraryApplication {
    private static final Logger logger = LogManager.getLogger(LibraryApplication.class);

    public static void main(String[] args) {
        System.out.println("ghreugh;hreu");
        logger.info("Starting Library Management System");

        LibraryService library = new LibraryServiceImpl();
        System.out.println("ghreugh;hreu");
        Book book1 = new Book("978-0134685991", "Introduction to Computing", "Me");
        Book book2 = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman");
        Book book3 = new Book("978-0132350884", "Clean Code", "Robert Martin");
        System.out.println("ghreugh;hreu");
        library.addBook(book1, 2);
        library.addBook(book2, 1);
        library.addBook(book3, 3);

        logger.info("Added books to library");
        Teacher teacher1 = new Teacher("T001", "Smith", "Yakub");
        Teacher teacher2 = new Teacher("T002", "Sahalu", "Junaidu");
        SeniorStudent senior1 = new SeniorStudent("S001", "Alice", "Johnson");
        SeniorStudent senior2 = new SeniorStudent("S002", "Bob", "Wilson");
        JuniorStudent junior1 = new JuniorStudent("J001", "Charlie", "Brown");
        JuniorStudent junior2 = new JuniorStudent("J002", "Diana", "Prince");

        logger.info("Created users with different priority levels");

        demonstrateBorrowingSystem(library, book1, teacher1, senior1, junior1, teacher2);


        logger.info("Total books: {}", library.getTotalCopies());

        logger.info("Library Management System demonstration completed");
    }

    private static void demonstrateBorrowingSystem(LibraryService library, Book book,
                                                   User teacher, User senior, User junior, User teacher2) {
        System.out.println("ghreugh;hrfbbbbbbbeu");
        String isbn = book.getIsbn();

        logger.info("\n=== Demonstrating Library Application ===");

        var request = new BookRequest(teacher, isbn);

        String result1 = library.borrowBook(request);
        logger.info("Teacher borrows first copy: {}", result1);

        var request2 = new BookRequest(senior, isbn);
        String result2 = library.borrowBook(request2);
        logger.info("Senior student borrows second copy: {}", result2);

        var request3 = new BookRequest(junior, isbn);
        String result3 = library.borrowBook(request3);
        logger.info("Junior student request (should be queued): {}", result3);

        var request4 = new BookRequest(teacher2, isbn);
        String result4 = library.borrowBook(request4);
        logger.info("Second teacher request (should be queued with higher priority): {}", result4);

        logger.info("\nReturning first copy...");
        library.returnBook(result1);

        logger.info("=== Priority System Demonstration Complete ===\n");
    }
}

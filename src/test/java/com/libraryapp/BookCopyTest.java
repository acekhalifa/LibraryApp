package com.libraryapp;

import com.library.entities.Book;
import com.library.entities.BookCopy;
import com.library.entities.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookCopyTest {
    void testBookCopyInitialization() {
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        BookCopy copy = new BookCopy("978-0134685991-1","Effective Java", "Joshua Bloch");

        assertEquals("978-0134685991-1", copy.getCopyId());
        assertTrue(copy.isAvailable());
    }

    @Test
    void testBorrowBook() {
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        BookCopy copy = new BookCopy("978-0134685991-1","Effective Java", "Joshua Bloch");
        Teacher teacher = new Teacher("T001", "Big", "Man");

        copy.borrowTo(teacher);

        assertFalse(copy.isAvailable());
//        assertEquals(teacher, copy.getBorrower());
    }

    @Test
    void testReturnBook() {
        Book book = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        BookCopy copy = new BookCopy("978-0134685991-1","Effective Java", "Joshua Bloch");
        Teacher teacher = new Teacher("T001", "Big", "Man");

        copy.borrowTo(teacher);
        copy.returnBook();

        assertTrue(copy.isAvailable());
    }

}

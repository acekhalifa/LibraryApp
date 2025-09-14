package com.libraryapp;

import com.library.entities.BookRequest;
import com.library.entities.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRequestTest {
    @Test
    void testBookRequestCreation() {
        Teacher teacher = new Teacher("T001", "Big", "Man");
        BookRequest request = new BookRequest(teacher, "978-0134685991");

        assertEquals(teacher, request.getUser());
        assertEquals("978-0134685991", request.getBookId());
    }
}

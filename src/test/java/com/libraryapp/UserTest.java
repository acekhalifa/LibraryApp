package com.libraryapp;

import com.library.entities.JuniorStudent;
import com.library.entities.SeniorStudent;
import com.library.entities.Teacher;
import com.library.entities.UserType;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testTeacherPriority() {
        Teacher teacher = new Teacher("T001", "Big", "Man");
        assertEquals(1, teacher.getPriority());
        assertEquals(UserType.TEACHER, teacher.getUserType());
    }

    @Test
    void testSeniorStudentPriority() {

        SeniorStudent senior = new SeniorStudent("S001", "Yunus", "Jonah");
        assertEquals(2, senior.getPriority());
        assertEquals(UserType.SENIOR_STUDENT, senior.getUserType());
    }

    @Test
    void testJuniorStudentPriority() {
        JuniorStudent junior = new JuniorStudent("J001", "Bob", "Alice");
        assertEquals(3, junior.getPriority());
        assertEquals(UserType.JUNIOR_STUDENT, junior.getUserType());
    }
}
package com.library.entities;

public class JuniorStudent extends Student {
    public JuniorStudent(String id, String firstName, String lastName) {
        super(id, firstName, lastName, UserType.JUNIOR_STUDENT);
    }

    public int getPriority() {
        return getUserType().getPriority();
    }
}

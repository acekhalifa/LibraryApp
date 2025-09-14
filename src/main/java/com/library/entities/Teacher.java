package com.library.entities;

public class Teacher extends User {
    public Teacher(String id, String firstName, String lastName) {
        super(id, firstName, lastName, UserType.TEACHER);
    }

    public int getPriority() {
        return getUserType().getPriority();
    }
}


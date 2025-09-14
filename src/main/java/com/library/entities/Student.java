package com.library.entities;

public abstract class Student extends User {
    public Student(String id, String firstName, String lastName, UserType userType) {
        super(id, firstName, lastName, userType);
    }
}

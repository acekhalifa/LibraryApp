package com.library.entities;

public class SeniorStudent extends Student {
    public SeniorStudent(String id, String firstName, String lastName) {
        super(id, firstName, lastName, UserType.SENIOR_STUDENT);
    }

    public int getPriority() {
        return getUserType().getPriority();
    }
}

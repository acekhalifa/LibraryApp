package com.library.entities;

public enum UserType {
    TEACHER(1),
    SENIOR_STUDENT(2),
    JUNIOR_STUDENT(3);

    private final int priority;

    UserType(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
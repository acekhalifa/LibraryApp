package com.library.entities;

public class BookCopy {
    private String copyId;
    private String title;
    private String author;
    private boolean available;

    public BookCopy(String copyId, String title, String author) {
        this.copyId = copyId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // Getters and setters
    public String getCopyId() { return copyId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
//    public User getBorrower() { return borrower; }

    public void borrowTo(User user) {
        if (!available) {
            throw new IllegalStateException("Book copy is already borrowed");
        }
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
    }

    @Override
    public String toString() {
        return String.format("BookCopy{copyId='%s', title=%s, available=%b}",
                copyId, title, available);
    }
}

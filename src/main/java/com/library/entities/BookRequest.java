package com.library.entities;

public class BookRequest implements Comparable<BookRequest>{
    private User user;
    private String bookId;

    public BookRequest(User user, String bookId) {
        this.user = user;
        this.bookId = bookId;
    }

    public User getUser() {
        return user;
    }

    public String getBookId() {
        return bookId;
    }

    @Override
    public int compareTo(BookRequest otherRequest) {
        return Integer.compare(user.getPriority(), otherRequest.getUser().getPriority());
    }
}

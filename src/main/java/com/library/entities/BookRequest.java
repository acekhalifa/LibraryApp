package com.library.entities;

public class BookRequest implements Comparable<User>{
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
    public int compareTo(User otherUser) {
        return Integer.compare(user.getPriority(), otherUser.getPriority());
    }
}

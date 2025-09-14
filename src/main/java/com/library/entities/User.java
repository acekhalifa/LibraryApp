package com.library.entities;

public abstract class User implements Comparable<User> {
    private String id;
    private String firstName;
    private String lastName;
    private UserType userType;

    public User(String id, String firstName , String lastName, UserType userType) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
    }

    // Getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() { return userType; }

    public abstract int getPriority();

    public int compareTo(User otherUser){
        return Integer.compare(getPriority(), otherUser.getPriority());
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id.equals(user.id);
    }

    public int hashCode() {
        return id.hashCode();
    }
}

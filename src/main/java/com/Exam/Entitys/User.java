package com.Exam.Entitys;

public abstract class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private UserType userType;

    // Constructor
    public User(int id, String fullName, String email, String password, UserType userType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    // Default constructor
    public User() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    // Abstract method for display information
    public abstract String displayInfo();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}
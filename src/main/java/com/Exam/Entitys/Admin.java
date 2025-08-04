package com.Exam.Entitys;

public class Admin extends User {

    // Constructor
    public Admin(int id, String fullName, String email, String password) {
        super(id, fullName, email, password, UserType.ADMIN);
    }

    // Default constructor
    public Admin() {
        super();
        setUserType(UserType.ADMIN);
    }

    @Override
    public String displayInfo() {
        return String.format("Admin - ID: %d, Name: %s, Email: %s",
                getId(), getFullName(), getEmail());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}
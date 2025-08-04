package com.Exam.Entitys;

public enum UserType {
    LEADER("Leader"),
    MEMBER("Member"),
    ADMIN("Admin");

    private final String displayName;

    UserType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
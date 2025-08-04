package com.Exam.Entitys;

public class Member extends User {
    private int projectId; // Project ID
    private String skill; // ky nang chuyen mon

    // Constructor
    public Member(int id, String fullName, String email, String password, int projectId, String skill) {
        super(id, fullName, email, password, UserType.MEMBER);
        this.projectId = projectId;
        this.skill = skill;
    }

    public Member() {
        super();
        setUserType(UserType.MEMBER);
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String displayInfo() {
        return String.format("Member - ID: %d, Name: %s, Email: %s, Project: %d, Skill: %s",
                getId(), getFullName(), getEmail(), projectId, skill);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", projectId=" + projectId +
                ", skill='" + skill + '\'' +
                '}';
    }
}
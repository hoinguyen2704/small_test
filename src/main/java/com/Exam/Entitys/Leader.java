package com.Exam.Entitys;

public class Leader extends User {
    private int numberOfProject; // so project la leader

    // Constructor
    public Leader(int id, String fullName, String email, String password, int numberOfProject) {
        super(id, fullName, email, password, UserType.LEADER);
        this.numberOfProject = numberOfProject;
    }

    public Leader() {
        super();
        setUserType(UserType.LEADER);
    }

    // Getter and Setter
    public int getNumberOfProject() {
        return numberOfProject;
    }

    public void setNumberOfProject(int numberOfProject) {
        this.numberOfProject = numberOfProject;
    }

    @Override
    public String displayInfo() {
        return String.format("Leader - ID: %d, Name: %s, Email: %s, Projects: %d",
                getId(), getFullName(), getEmail(), numberOfProject);
    }

    @Override
    public String toString() {
        return "Leader{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", numberOfProject=" + numberOfProject +
                '}';
    }
}
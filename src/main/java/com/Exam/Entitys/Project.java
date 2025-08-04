package com.Exam.Entitys;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int projectId; // Project ID
    private String projectName; // Project name
    private int size; // Number of members in the project
    private int leaderId; // ID of the Leader (Team leader)
    private List<Member> employees; // List of members in the project

    // Constructor
    public Project(int projectId, String projectName, int size, int leaderId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.size = size;
        this.leaderId = leaderId;
        this.employees = new ArrayList<>();
    }

    public Project() {
        this.employees = new ArrayList<>();
    }

    // Getters and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public List<Member> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Member> employees) {
        this.employees = employees;
    }

    // them thanh vien vao project
    public void addEmployee(Member member) {
        if (member != null && !employees.contains(member)) {
            employees.add(member);
            member.setProjectId(this.projectId);
        }
    }

    // xoa thanh vien khoi project
    public void removeEmployee(Member member) {
        if (member != null) {
            employees.remove(member);
        }
    }

    // lay thong tin project theo format
    public String getProjectInfoAsTable() {
        StringBuilder table = new StringBuilder();
        table.append(String.format("| Project ID: %-53d |\n", projectId));
        table.append(String.format("| Project Name: %-51s |\n", projectName));
        table.append(String.format("| Size: %-59d |\n", size));
        table.append(String.format("| Leader ID: %-54d |\n", leaderId));
        table.append("| ID  | Full Name           | Email                    | Skill      |\n");

        for (Member member : employees) {
            table.append(String.format("| %-3d | %-19s | %-24s | %-10s |\n",
                    member.getId(),
                    member.getFullName(),
                    member.getEmail(),
                    member.getSkill()));
        }
        return table.toString();
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", size=" + size +
                ", leaderId=" + leaderId +
                ", employees=" + employees +
                '}';
    }
}
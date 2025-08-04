package com.Exam.Repository;

import com.Exam.Entitys.Leader;
import com.Exam.Entitys.Member;
import com.Exam.Entitys.Project;
import com.Exam.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    public Project getProjectByName(String projectName) {
        String projectSql = "SELECT * FROM projects WHERE project_name = ?";
        String membersSql = "SELECT u.* FROM users u JOIN project_members pm ON u.id = pm.user_id WHERE pm.project_id = ?";
        Project project = null;
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement projectPstmt = conn.prepareStatement(projectSql)) {
            projectPstmt.setString(1, projectName);
            ResultSet projectRs = projectPstmt.executeQuery();
            if (projectRs.next()) {
                project = new Project(projectRs.getInt("project_id"), projectRs.getString("project_name"), projectRs.getInt("size"), projectRs.getInt("leader_id"));
                try (PreparedStatement membersPstmt = conn.prepareStatement(membersSql)) {
                    membersPstmt.setInt(1, project.getProjectId());
                    ResultSet membersRs = membersPstmt.executeQuery();
                    List<Member> members = new ArrayList<>();
                    while (membersRs.next()) {
                        members.add(new Member(membersRs.getInt("id"), membersRs.getString("full_name"), membersRs.getString("email"), membersRs.getString("password"), membersRs.getInt("project_id"), membersRs.getString("skill")));
                    }
                    project.setEmployees(members);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }
}

package com.Exam.Repository;

import com.Exam.Entitys.*;
import com.Exam.Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                UserType userType = UserType.valueOf(rs.getString("user_type"));
                switch (userType) {
                    case ADMIN:
                        return new Admin(rs.getInt("id"), rs.getString("full_name"), rs.getString("email"), rs.getString("password"));
                    case LEADER:
                        return new Leader(rs.getInt("id"), rs.getString("full_name"), rs.getString("email"), rs.getString("password"), rs.getInt("number_of_projects"));
                    case MEMBER:
                        return new Member(rs.getInt("id"), rs.getString("full_name"), rs.getString("email"), rs.getString("password"), rs.getInt("project_id"), rs.getString("skill"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User createUser(String fullName, String email) {
        String sql = "INSERT INTO users (full_name, email, password, user_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, fullName);
            pstmt.setString(2, email);
            pstmt.setString(3, "12345678");
            pstmt.setString(4, "MEMBER");
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    return new Member(id, fullName, email, "12345678", 0, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

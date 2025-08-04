package com.Exam.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * JDBC Utility Class
 * Provides database connection and utility methods for SQL operations
 */
public class JDBCUtils {

	// Database configuration
	private static final String URL = "jdbc:mysql://localhost:3306/project_management?useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// tạo 1 đối tượng connection đến database
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// Thêm rollback nếu có lỗi khi đã mở connection
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException rollbackEx) {
					System.out.println("Lỗi khi rollback: " + rollbackEx.getMessage());
				}
			}
		}
		return connection;
	}
}

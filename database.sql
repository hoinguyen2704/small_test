-- Project Member Management System Database Schema
-- Created for Final Exam Application

-- Create database
CREATE DATABASE IF NOT EXISTS project_management;
USE project_management;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS project_members;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type ENUM('LEADER', 'MEMBER', 'ADMIN') NOT NULL,
    number_of_projects INT DEFAULT 0,
    project_id INT DEFAULT NULL,
    skill VARCHAR(100) DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create projects table
CREATE TABLE projects (
    project_id INT PRIMARY KEY AUTO_INCREMENT,
    project_name VARCHAR(100) NOT NULL,
    size INT NOT NULL,
    leader_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (leader_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Create project_members table (many-to-many relationship)
CREATE TABLE project_members (
    id INT PRIMARY KEY AUTO_INCREMENT,
    project_id INT NOT NULL,
    user_id INT NOT NULL,
    joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    UNIQUE KEY unique_project_member (project_id, user_id)
);

-- Insert initial data

-- Insert Admin users
INSERT INTO users (full_name, email, password, user_type) VALUES
('Admin User 1', 'admin1@company.com', 'Admin123!', 'ADMIN'),
('Admin User 2', 'admin2@company.com', 'Admin456!', 'ADMIN');

-- Insert Leader users
INSERT INTO users (full_name, email, password, user_type, number_of_projects) VALUES
('Nguyen Van A', 'leader1@company.com', 'Leader123!', 'LEADER', 2),
('Tran Thi B', 'leader2@company.com', 'Leader456!', 'LEADER', 1),
('Le Van C', 'leader3@company.com', 'Leader789!', 'LEADER', 0);

-- Insert Member users
INSERT INTO users (full_name, email, password, user_type, skill) VALUES
('Pham Van D', 'member1@company.com', 'Member123!', 'MEMBER', 'Java'),
('Hoang Thi E', 'member2@company.com', 'Member456!', 'MEMBER', 'Python'),
('Vu Van F', 'member3@company.com', 'Member789!', 'MEMBER', 'JavaScript'),
('Do Thi G', 'member4@company.com', 'Member101!', 'MEMBER', 'React'),
('Ngo Van H', 'member5@company.com', 'Member202!', 'MEMBER', 'Node.js'),
('Ly Thi I', 'member6@company.com', 'Member303!', 'MEMBER', 'MySQL');

-- Insert Projects
INSERT INTO projects (project_name, size, leader_id) VALUES
('E-Commerce Platform', 5, 3),  -- leader1@company.com
('Mobile Banking App', 3, 4),    -- leader2@company.com
('Inventory Management', 4, 3);  -- leader1@company.com

-- Insert project members
INSERT INTO project_members (project_id, user_id) VALUES
-- E-Commerce Platform members
(1, 5),  -- member1@company.com
(1, 6),  -- member2@company.com
(1, 7),  -- member3@company.com
(1, 8),  -- member4@company.com

-- Mobile Banking App members
(2, 5),  -- member1@company.com
(2, 9),  -- member5@company.com
(2, 10), -- member6@company.com

-- Inventory Management members
(3, 6),  -- member2@company.com
(3, 7),  -- member3@company.com
(3, 8),  -- member4@company.com
(3, 9);  -- member5@company.com

-- Update leader's number_of_projects
UPDATE users SET number_of_projects = 2 WHERE id = 3;  -- Nguyen Van A
UPDATE users SET number_of_projects = 1 WHERE id = 4;  -- Tran Thi B

-- Create indexes for better performance
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_type ON users(user_type);
CREATE INDEX idx_projects_name ON projects(project_name);
CREATE INDEX idx_project_members_project ON project_members(project_id);
CREATE INDEX idx_project_members_user ON project_members(user_id);

-- Show created data
SELECT 'Users Table:' as info;
SELECT * FROM users;

SELECT 'Projects Table:' as info;
SELECT * FROM projects;

SELECT 'Project Members Table:' as info;
SELECT * FROM project_members; 
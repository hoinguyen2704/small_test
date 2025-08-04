package com.Exam.Controllers;

import com.Exam.Entitys.Admin;
import com.Exam.Entitys.Project;
import com.Exam.Entitys.User;
import com.Exam.Services.ProjectService;
import com.Exam.Services.UserService;

import java.util.Scanner;

public class UserController {

    private UserService userService = new UserService();
    private ProjectService projectService = new ProjectService();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to the Project Member Management!");
        while (true) {
            System.out.println("\ntuy chon:");
            System.out.println("1. Dang Nhap");
            System.out.println("2. Thoat");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Dang Thoat...");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    private void login() {
        System.out.print("nhap email: ");
        String email = scanner.nextLine();
        System.out.print("nhap password: ");
        String password = scanner.nextLine();

        User user = userService.login(email, password);

        if (user != null) {
            System.out.println("dang nhap thanh cong: " + user.getFullName());
            showMenu(user);
        } else {
            System.out.println("email hoac mat khau khong dung. Vui long thu lai.");
        }
    }

    private void showMenu(User user) {
        switch (user.getUserType()) {
            case ADMIN:
                showAdminMenu((Admin) user);
                break;
            case LEADER:
            case MEMBER:
                showUserMenu();
                break;
        }
    }

    private void showAdminMenu(Admin admin) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Create new user");
            System.out.println("2. View project members");
            System.out.println("3. Thoat");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    viewProjectMembers();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View project members");
            System.out.println("2. Thoat");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewProjectMembers();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createUser() {
        System.out.print("Nhap ten: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhap email: ");
        String email = scanner.nextLine();

        User newUser = userService.createUser(fullName, email);

        if (newUser != null) {
            System.out.println("Tao user thanh cong:");
            System.out.println(newUser);
        } else {
            System.out.println("Tao user that bai.");
        }
    }

    private void viewProjectMembers() {
        System.out.print("Nhap ten project: ");
        String projectName = scanner.nextLine();

        Project project = projectService.getProjectByName(projectName);

        if (project != null) {
            System.out.println(project.getProjectInfoAsTable());
        } else {
            System.out.println("Khong tim thay project voi ten: " + projectName + ".");
        }
    }
}

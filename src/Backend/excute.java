package Backend;

import java.util.ArrayList;

import entity.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class excute {
	static ArrayList<User> lsUser = new ArrayList<User>();
	static Scanner sc = new Scanner(System.in);

	// 2. Tạo mới User
	public static void createNewUser() {
		System.out.print("Nhập loại user (1-Admin, 2-Employee): ");
		int type = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập fullName: ");
		String fullName = sc.nextLine();
		System.out.print("Nhập email: ");
		String email = sc.nextLine();
		System.out.print("Nhập password: ");
		String password = sc.nextLine();
		if (type == 1) {
			System.out.print("Nhập số năm kinh nghiệm: ");
			int exp = Integer.parseInt(sc.nextLine());
			lsUser.add(new Admin(id, fullName, email, password, exp));
		} else {
			System.out.print("Nhập proSkill: ");
			String proSkill = sc.nextLine();
			lsUser.add(new Employee(id, fullName, email, password, proSkill));
		}
		System.out.println("Tạo user thành công!");
	}

	// 3. In thông tin id, fullName, Email của tất cả User
	public static void printAllUsers() {
		System.out.println("Danh sách User:");
		for (User u : lsUser) {
			System.out.println("ID: " + u.getId() + ", FullName: " + u.getFullName() + ", Email: " + u.getEmail());
		}
	}

	// 4. In thông tin User theo id
	public static void printUserById() {
		System.out.print("Nhập id: ");
		int id = Integer.parseInt(sc.nextLine());
		for (User u : lsUser) {
			if (u.getId() == id) {
				System.out.println(u);
				return;
			}
		}
		System.out.println("Không tìm thấy user với id này!");
	}

	// 5. Xóa User theo id
	public static void deleteUserById() {
		System.out.print("Nhập id: ");
		int id = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < lsUser.size(); i++) {
			if (lsUser.get(i).getId() == id) {
				lsUser.remove(i);
				System.out.println("Đã xóa user!");
				return;
			}
		}
		System.out.println("Không tìm thấy user với id này!");
	}

	// 6. Login
	public static User login() {
		System.out.print("Nhập email: ");
		String email = sc.nextLine();
		if (!isValidEmail(email)) {
			System.out.println("Email không hợp lệ!");
			return null;
		}
		System.out.print("Nhập password: ");
		String password = sc.nextLine();
		if (!isValidPassword(password)) {
			System.out.println("Password không hợp lệ!");
			return null;
		}
		for (User u : lsUser) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				System.out.println("Đăng nhập thành công!");
				return u;
			}
		}
		System.out.println("Sai email hoặc password!");
		return null;
	}

	// 7. Tạo Employee cho Admin
	public static void createEmployeeByAdmin() {
		System.out.print("Nhập fullName: ");
		String fullName = sc.nextLine();
		if (!isValidFullName(fullName)) {
			System.out.println("FullName không hợp lệ!");
			return;
		}
		System.out.print("Nhập email: ");
		String email = sc.nextLine();
		if (!isValidEmail(email)) {
			System.out.println("Email không hợp lệ!");
			return;
		}
		int id = lsUser.size() + 1;
		String password = "123456";
		System.out.print("Nhập proSkill: ");
		String proSkill = sc.nextLine();
		lsUser.add(new Employee(id, fullName, email, password, proSkill));
		System.out.println("Tạo employee thành công!");
	}

	// Validate email
	public static boolean isValidEmail(String email) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return Pattern.matches(regex, email);
	}

	// Validate password
	public static boolean isValidPassword(String password) {
		if (password.length() < 6 || password.length() > 12)
			return false;
		boolean hasUpper = false;
		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c))
				hasUpper = true;
		}
		return hasUpper;
	}

	// Validate fullName
	public static boolean isValidFullName(String fullName) {
		return fullName.matches("[a-zA-Z\\s]+$");
	}

	public static void menu() {
		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Tạo mới User");
			System.out.println("2. In danh sách User");
			System.out.println("3. In thông tin User theo id");
			System.out.println("4. Xóa User theo id");
			System.out.println("5. Login");
			System.out.println("0. Thoát");
			System.out.print("Chọn chức năng: ");
			String choice = sc.nextLine();
			switch (choice) {
				case "1":
					createNewUser();
					break;
				case "2":
					printAllUsers();
					break;
				case "3":
					printUserById();
					break;
				case "4":
					deleteUserById();
					break;
				case "5":
					User u = login();
					if (u instanceof Admin) {
						System.out.println("Bạn là Admin. Muốn tạo Employee mới? (y/n)");
						String ans = sc.nextLine();
						if (ans.equalsIgnoreCase("y")) {
							createEmployeeByAdmin();
						}
					}
					break;
				case "0":
					System.out.println("Thoát");
					return;
				default:
					System.out.println("Chọn sai");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lsUser.add(new Admin(1, "Tran Thanh Luan", "luan12@gmail.com", "Luan123", 1));
		lsUser.add(new Employee(2, "Nguyen Tien Hoi", "hoi@gmail.com", "Hoi1234", "c++"));
		lsUser.add(new Employee(3, "Tran Quan", "quan@gmail.com", "Quan1234", "python"));
		menu();
	}

}

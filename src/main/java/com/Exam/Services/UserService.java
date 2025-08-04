package com.Exam.Services;

import com.Exam.Entitys.User;
import com.Exam.Repository.UserRepository;

import java.util.regex.Pattern;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User login(String email, String password) {
        if (!isValidEmail(email) || !isValidPassword(password)) {
            return null;
        }
        return userRepository.login(email, password);
    }

    public User createUser(String fullName, String email) {
        if (!isValidEmail(email) || !isValidFullName(fullName)) {
            return null;
        }
        return userRepository.createUser(fullName, email);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6 && password.length() <= 10 && password.matches(".*[A-Z].*");
    }

    private boolean isValidFullName(String fullName) {
        return fullName.matches("[a-zA-Z ]+");
    }
}

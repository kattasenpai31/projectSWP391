/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Dell
 */
// PasswordValidator.java
public class PasswordValidator {

    // Method to validate password
    public static boolean validatePassword(String password) {
        // Check for a minimum password length
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }

        // Check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }

        // Check if password contains at least one digit
        if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        // Check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        // If all conditions are met, password is valid
        return true;
    }

    // Main method to test the password validation
    public static void main(String[] args) {
        String testPassword = "StrongPass1!";
        
        // Test the validation method
        if (validatePassword(testPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}


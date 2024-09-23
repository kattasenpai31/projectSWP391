package model;

public class SignupStaff {
    
    // Fields for staff sign-up details
    private String staffName;
    private String staffEmail;
    private String staffID;
    private String department;
    private String password;

    // Constructor
    public SignupStaff(String staffName, String staffEmail, String staffID, String department, String password) {
        this.staffName = staffName;
        this.staffEmail = staffEmail;
        this.staffID = staffID;
        this.department = department;
        this.password = password;
    }

    // Getter and Setter methods
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to display staff information
    public void displayStaffInfo() {
        System.out.println("Staff Name: " + staffName);
        System.out.println("Staff Email: " + staffEmail);
        System.out.println("Staff ID: " + staffID);
        System.out.println("Department: " + department);
    }

    // Method to validate the password
    public boolean validatePassword() {
        // Password should be at least 8 characters long
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Password should contain at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }

        // Password should contain at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }

        // Password should contain at least one digit
        if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        // Password should contain at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        // Password is valid if all conditions are met
        return true;
    }

    public static void main(String[] args) {
        // Test the password validation
        SignupStaff staff = new SignupStaff("John Doe", "john.doe@example.com", "S1234", "IT", "Password123!");
        
        staff.displayStaffInfo();
        
        if (staff.validatePassword()) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}

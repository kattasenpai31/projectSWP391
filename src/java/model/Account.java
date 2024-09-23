
package model;


public class Account {
      private int accountID;
    private int roleID;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private int statusID;
    private int totalBuyingPoints;

    public Account() {
    }

    public Account(int accountID, int roleID, String username, String password, String fullName, String email, String phone, String address, int statusID, int totalBuyingPoints) {
        this.accountID = accountID;
        this.roleID = roleID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.statusID = statusID;
        this.totalBuyingPoints = totalBuyingPoints;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getTotalBuyingPoints() {
        return totalBuyingPoints;
    }

    public void setTotalBuyingPoints(int totalBuyingPoints) {
        this.totalBuyingPoints = totalBuyingPoints;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", roleID=" + roleID + ", username=" + username + ", password=" + password + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", address=" + address + ", statusID=" + statusID + ", totalBuyingPoints=" + totalBuyingPoints + '}';
    }
    
    
}

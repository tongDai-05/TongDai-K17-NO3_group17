package com.example.servingwebcontent.model;

public class User {
    private String userID;
    private String userName;
    private String address;

    public User() {} // constructor mặc định

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public void displayInfo() {
        System.out.println("[" + userID + "] " + userName + " - " + address);
    }

    // 👇 Thêm dòng này để tránh lỗi ở LoginController
    public void printUserName() {
        System.out.println("Tên người dùng: " + userName);
    }
}

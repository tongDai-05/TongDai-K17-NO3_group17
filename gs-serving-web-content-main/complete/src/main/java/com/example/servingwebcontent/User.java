package com.example.servingwebcontent;
public class User{
    private String id;
    private String name;

    public String getUserID(){ return userID; }
    public void setUserID(String uid){ this.userID = uid; }

    public String getUserName(){ return userName; }
    public void setUserName(String name){ this.userName = name; }

    public void displayInfo(){
        System.out.println("["+ id +"]" + name);
    }
}
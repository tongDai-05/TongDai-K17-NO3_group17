package com.example.servingwebcontent.component;

import java.util.ArrayList;

import com.example.servingwebcontent.model.User;

public class ListUser {
    public void printListUser(ArrayList<User> listUser) {
        System.out.println("List user:");
        for (User user : listUser) {
            System.out.println(user.getUserName());
            System.out.println(user.getAddress());
            System.out.println(user.getUserID());
        }
    }
}

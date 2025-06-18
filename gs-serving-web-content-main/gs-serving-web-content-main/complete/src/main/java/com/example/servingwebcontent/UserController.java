package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.User;
import com.example.servingwebcontent.database.insertToAiven;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    // Trang hiển thị danh sách user (tạm thời chưa load từ database)
    @GetMapping("/list")
    public String listUsers(Model model) {
        ArrayList<User> users = new ArrayList<>();
        // Demo 2 user mẫu
        User u1 = new User();
        u1.setUserName("Nguyen Van A");
        u1.setAddress("Hanoi");
        u1.setUserID("u1");

        User u2 = new User();
        u2.setUserName("Tran Thi B");
        u2.setAddress("HCM");
        u2.setUserID("u2");

        users.add(u1);
        users.add(u2);

        model.addAttribute("users", users);
        return "userlist";
    }

    // Hiển thị form thêm user
    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    // Xử lý thêm user
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, Model model) {
        insertToAiven db = new insertToAiven();
        db.insertToAivenDb(user);
        model.addAttribute("message", "Đã thêm người dùng thành công!");
        return "redirect:/user/list";
    }
}

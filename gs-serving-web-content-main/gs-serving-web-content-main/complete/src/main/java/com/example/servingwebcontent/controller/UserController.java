package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.UserAiven;
import com.example.servingwebcontent.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserAiven userAiven;

    @Autowired
    public UserController(UserAiven userAiven) {
        this.userAiven = userAiven;
    }

    // ✅ Hiển thị danh sách người dùng
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userAiven.getAllUsers();
        model.addAttribute("users", users);
        return "user/list"; // templates/user/list.html
    }

    // ✅ Hiển thị form thêm người dùng
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add"; // templates/user/add.html
    }
    //co thu test

    @GetMapping("user/add")
    public String addFormUser() {
       
        return "user/add1"; // templates/user/add.html
    }
    
    @GetMapping("/user/getAdd")
    public String addUserForm(@ModelAttribute User user) {
        userAiven.insertUser(user);
        return "user/add1";
    }

    //het test co Thu


    // ✅ Xử lý thêm người dùng
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userAiven.insertUser(user);
        return "redirect:/user";
    }

    // ✅ Hiển thị form chỉnh sửa người dùng
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String userID, Model model) {
        User user = userAiven.findUserById(userID);
        if (user == null) {
            return "redirect:/user";
        }
        model.addAttribute("user", user);
        return "user/edit"; // templates/user/edit.html
    }

    // ✅ Xử lý cập nhật người dùng
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") String userID, @ModelAttribute User user) {
        user.setUserID(userID); // Giữ nguyên ID
        userAiven.updateUser(user);
        return "redirect:/user";
    }

    // ✅ Xóa người dùng
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String userID) {
        userAiven.deleteUser(userID);
        return "redirect:/user";
    }
}

package com.walker.security.controller;

import com.walker.security.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String listUser(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "jack", 20));
        users.add(new User(3L, "taro", 30));
        users.add(new User(5L, "west", 50));
        model.addAttribute("title", "用户列表");
        model.addAttribute("users", users);
        return "users/list";
    }
}

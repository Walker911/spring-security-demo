package com.walker.security.controller;

import com.walker.security.model.User;
import com.walker.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUser(Model model) {
        List<User> users = userService.listUser();
        model.addAttribute("title", "用户列表");
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/users/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.removeUser(id);
        model.addAttribute("title", "删除用户");
        model.addAttribute("users", userService.listUser());
        return "users/list";
    }
}

package com.walker.security.controller;

import com.walker.security.model.User;
import com.walker.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admins")
    public String listAdmin(Model model) {
        List<User> admins = userService.listUser();
        model.addAttribute("title", "管理员列表");
        model.addAttribute("admins", admins);
        return "admins/list";
    }
}

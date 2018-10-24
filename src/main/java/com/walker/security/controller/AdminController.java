package com.walker.security.controller;

import com.walker.security.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @GetMapping("/admins")
    public String listAdmin(Model model) {
        List<User> admins = new ArrayList<>();
        admins.add(new User(1L, "CEO", 20));
        admins.add(new User(2L, "CTO", 30));
        admins.add(new User(3L, "CFO", 40));
        model.addAttribute("title", "管理员列表");
        model.addAttribute("admins", admins);
        return "admins/list";
    }
}

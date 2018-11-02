package com.walker.security.controller;

import com.walker.security.model.Authority;
import com.walker.security.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/authorities")
    public String listAuthority(Model model) {
        List<Authority> authorities = authorityService.listAuthority();
        model.addAttribute("title", "角色列表");
        model.addAttribute("authorities", authorities);
        return "authorities/list";
    }
}

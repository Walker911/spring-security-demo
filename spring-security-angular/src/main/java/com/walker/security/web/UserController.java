package com.walker.security.web;

import com.walker.security.common.ResultBean;
import com.walker.security.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/2/28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public ResultBean<?> login() {
        return null;
    }

    @PostMapping("/register")
    public ResultBean<User> register() {
        return null;
    }

    @GetMapping("/logout")
    public ResultBean<?> logout() {
        return null;
    }
}

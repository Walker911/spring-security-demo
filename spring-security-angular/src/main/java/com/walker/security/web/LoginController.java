package com.walker.security.web;

import com.walker.security.common.ResultBean;
import com.walker.security.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/2/28
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public ResultBean<User> login() {
        return null;
    }
}

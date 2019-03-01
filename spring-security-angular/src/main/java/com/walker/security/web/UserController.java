package com.walker.security.web;

import com.walker.security.common.ResultBean;
import com.walker.security.dto.UserDTO;
import com.walker.security.model.User;
import com.walker.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author walker
 * @date 2019/2/28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResultBean<?> login() {
        return null;
    }

    @PostMapping("/add")
    public ResultBean<String> add(@RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);
        return ResultBean.success(user.getId());
    }

    @GetMapping("/logout")
    public ResultBean<?> logout() {
        return null;
    }
}

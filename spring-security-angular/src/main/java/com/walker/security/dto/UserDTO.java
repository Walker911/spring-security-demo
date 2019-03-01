package com.walker.security.dto;

import com.walker.security.model.Role;
import lombok.Data;

import java.util.List;

/**
 * @author walker
 * @date 2019/3/1
 */
@Data
public class UserDTO {

    private String username;

    private String password;

    private List<Role> roles;
}

package com.walker.security.service.impl;

import com.walker.security.mapper.RoleMapper;
import com.walker.security.mapper.UserMapper;
import com.walker.security.model.Role;
import com.walker.security.model.User;
import com.walker.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.queryUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s, 用户不存在", username));
        }
        List<Role> roles = roleMapper.queryRolesByUserId(user.getId());
        user.setRoles(roles);
        return user;
    }
}

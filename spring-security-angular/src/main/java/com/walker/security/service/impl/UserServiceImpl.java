package com.walker.security.service.impl;

import com.walker.security.dto.UserDTO;
import com.walker.security.model.User;
import com.walker.security.model.UserRole;
import com.walker.security.repository.UserRepository;
import com.walker.security.repository.UserRoleRepository;
import com.walker.security.service.UserService;
import com.walker.security.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author walker
 * @date 2019/3/1
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null) {

        }
        user = new User();
        user.setId(UUIDUtil.generate());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User finalUser = user;
        List<UserRole> userRoles = userDTO.getRoles().stream().map(role -> {
            UserRole userRole = new UserRole();
            userRole.setId(UUIDUtil.generate());
            userRole.setRoleId(role.getId());
            userRole.setUserId(finalUser.getId());
            return userRole;
        }).collect(Collectors.toList());
        userRepository.save(user);
        userRoleRepository.saveAll(userRoles);
        return user;
    }
}

package com.walker.security.service;

import com.walker.security.model.User;

import java.util.List;

public interface UserService {

    int removeUser(Long id);

    List<User> listUser();
}

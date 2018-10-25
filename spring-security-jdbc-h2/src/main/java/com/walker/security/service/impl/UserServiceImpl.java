package com.walker.security.service.impl;

import com.walker.security.model.User;
import com.walker.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {

    private static final Map<Long, User> userRepository = new ConcurrentHashMap<>();

    public UserServiceImpl() {
        userRepository.put(1L, new User(1L, "Jack", 20));
        userRepository.put(2L, new User(2L, "James", 21));
        userRepository.put(3L, new User(3L, "John", 22));
    }

    @Override
    public int removeUser(Long id) {
        userRepository.remove(id);
        return 0;
    }

    @Override
    public List<User> listUser() {
        List<User> users = new ArrayList<>(userRepository.values());
        return users;
    }
}

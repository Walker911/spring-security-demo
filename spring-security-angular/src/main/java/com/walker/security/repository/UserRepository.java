package com.walker.security.repository;

import com.walker.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author walker
 * @date 2018/12/20
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * find user by username
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
}

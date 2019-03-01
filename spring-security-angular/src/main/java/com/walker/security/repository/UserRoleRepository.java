package com.walker.security.repository;

import com.walker.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author walker
 * @date 2019/3/1
 */
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}

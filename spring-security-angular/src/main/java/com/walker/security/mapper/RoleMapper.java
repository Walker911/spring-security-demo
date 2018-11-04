package com.walker.security.mapper;

import com.walker.security.model.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> queryRolesByUserId(Long userId);
}

package com.walker.security.service;

import com.walker.security.dto.UserDTO;
import com.walker.security.model.User;

/**
 * @author walker
 * @date 2019/3/1
 */
public interface UserService {

    /**
     * 保存
     *
     * @param userDTO
     * @return
     */
    User save(UserDTO userDTO);
}

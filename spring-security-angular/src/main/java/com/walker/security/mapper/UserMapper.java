package com.walker.security.mapper;

import com.walker.security.model.User;
import org.apache.ibatis.annotations.SelectProvider;

public interface UserMapper {
    @SelectProvider(type=UserMapperProvider.class, method = "queryUserByName")
    User queryUserByName(String name);
}

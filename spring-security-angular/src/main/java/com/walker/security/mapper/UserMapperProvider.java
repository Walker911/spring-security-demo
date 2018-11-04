package com.walker.security.mapper;

import org.apache.ibatis.jdbc.SQL;

public class UserMapperProvider {
    public String queryUserByName(String name) {
        return new SQL()
                .SELECT("id", "username", "password", "age")
                .FROM("user")
                .WHERE("username = #{username}")
                .toString();
    }
}

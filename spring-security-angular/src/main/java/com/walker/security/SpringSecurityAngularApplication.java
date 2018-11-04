package com.walker.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.walker.security.mapper")
public class SpringSecurityAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAngularApplication.class, args);
    }
}

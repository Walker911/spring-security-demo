package com.walker.security;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

/**
 * @author walker
 * @date 2019/3/1
 */
public class PasswordTest {

    @Test
    public void generatePassword() {
        String password = "123456";
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String result = passwordEncoder.encode(password);
        System.out.println(result);
    }

    @Test
    public void generateUUID() {
        String id = UUID.randomUUID().toString().replace("-", "");
        System.out.println(id);
    }
}

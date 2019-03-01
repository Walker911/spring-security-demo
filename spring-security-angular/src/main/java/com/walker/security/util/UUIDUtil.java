package com.walker.security.util;

import java.util.UUID;

/**
 * @author walker
 * @date 2019/3/1
 */
public class UUIDUtil {

    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

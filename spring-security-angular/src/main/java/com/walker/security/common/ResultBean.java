package com.walker.security.common;

import lombok.Data;

import java.util.Map;

/**
 * @author walker
 * @date 2019/2/21
 */
@Data
public class ResultBean<T> {

    private int code;

    private String message;

    private T data;

    private Map<String, Object> ext;

    private static final int SUCCESS = 0;

    private static final String SUCCESS_MESSAGE = "SUCCESS";

    public ResultBean() {
    }

    public ResultBean(int code, String message, T data, Map<String, Object> ext) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }

    public static <T> ResultBean<T> success() {
        return success(null);
    }

    public static <T> ResultBean<T> success(T data) {
        return success(data, null);
    }

    public static <T> ResultBean<T> success(T data, Map<String, Object> ext) {
        return new ResultBean<>(SUCCESS, SUCCESS_MESSAGE, data, ext);
    }

    public static <T> ResultBean<T> error(String message) {
        return error(-1, message);
    }

    public static <T> ResultBean<T> error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> ResultBean<T> error(int code, String message, T data) {
        return new ResultBean<>(code, message, data, null);
    }
}

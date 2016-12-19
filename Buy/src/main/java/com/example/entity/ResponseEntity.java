package com.example.entity;

/**
 * Created by feint on 16/12/14.
 */
public class ResponseEntity<T> {
    public static int NO_USER=11;
    public static int PASSWORD_WORING=12;

    public static int HAS_USERNAME=21;
    public static int HAS_EMAIL=22;

    public static int SUCCESS=200;

    private int code;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.springboot.luckymoney.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String email;

    public User(int id, String name, int age, String email) {
    }
}

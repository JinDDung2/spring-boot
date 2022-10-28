package com.example.hello.domain;

import lombok.Getter;

@Getter
public class User {
    private String id;
    private String name;
    private String password;
    private String email;

    public User(String id,String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

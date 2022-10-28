package com.example.hello.domain.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private String id;
    private String name;
    private String password;
    private String email;

    public UserDto(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}

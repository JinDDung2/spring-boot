package com.example.hello.domain.dto;

import lombok.Getter;

@Getter
public class MemberDto {
    private String name;
    private String email;
    private String organization;

    public MemberDto(String name, String email, String organization) {
        this.name = name;
        this.email = email;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}

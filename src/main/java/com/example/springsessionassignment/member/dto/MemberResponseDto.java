package com.example.springsessionassignment.member.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String email;

    public MemberResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}

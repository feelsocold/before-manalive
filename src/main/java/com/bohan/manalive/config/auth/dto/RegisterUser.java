package com.bohan.manalive.config.auth.dto;

import com.bohan.manalive.domain.user.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RegisterUser {

    private String email;
    private String name;
    private String password;
    private String nickname;
    private String phone;
    private String enable = "1";
    private Role role;

}

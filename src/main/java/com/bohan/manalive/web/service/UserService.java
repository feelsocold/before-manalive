package com.bohan.manalive.web.service;

import com.bohan.manalive.config.auth.dto.RegisterUser;
import com.bohan.manalive.domain.user.Role;
import com.bohan.manalive.domain.user.User;
import com.bohan.manalive.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long generalRegister(RegisterUser user) {
        return userRepository.save(User.builder()
                                    .email(user.getEmail())
                                    .name(user.getName())
                                    .password(user.getPassword())
                                    .nickname(user.getNickname())
                                    .phone(user.getPhone())
                                    .enable("1")
                                    .role(Role.USER)
                                    .build()).getSeq();
    }

}

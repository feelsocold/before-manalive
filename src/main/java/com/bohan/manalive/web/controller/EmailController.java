package com.bohan.manalive.web.controller;

import com.bohan.manalive.web.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class EmailController {

    private final EmailService emailService;

    @PostMapping(value="/mail")
    public void home3(HttpServletRequest req, String addrs ){

        emailService.sendSimpleMessage(addrs, "제목", "내용");

    }
}

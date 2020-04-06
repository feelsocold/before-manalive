package com.bohan.manalive.web.restController;

import com.bohan.manalive.config.auth.dto.RegisterUser;
import com.bohan.manalive.web.service.EmailService;
import com.bohan.manalive.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class AccountController {

    private final EmailService emailService;
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(getClass());

    // 회원가입시 이메일로 인증번호 전송
    @PostMapping("/authentication_send")
    public int mailSend(HttpServletRequest req, String addrs, String to) throws MailException, MessagingException {
        logger.info("이메일 주소 : " +  to);
        int numberSix = emailService.sendSimpleMessage(to, "제목", "내용");
        return numberSix;
    }

    // 회원가입시 이메일 중복체크
    @PostMapping("/duplicate_check")
    public Boolean duplicate_check(String email) {
        boolean bool = userService.duplicateCheck(email);
        return bool;
    }

    // 로그인시 아이디+비밀번호 확인
    @PostMapping("/loginCheck")
    public void loginCheck(RegisterUser user) {
        logger.info(user.toString());
        //return false;
    }
}
package com.bohan.manalive.web.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    public void sendSimpleMessage(String to, String subject, String text);

    public SimpleMailMessage createMessage(String to, String subject, String text);
}

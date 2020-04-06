package com.bohan.manalive.web.service;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;

public interface EmailService {

    public int sendSimpleMessage(String to, String subject, String text) throws MessagingException;

}

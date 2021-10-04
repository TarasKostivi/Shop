package com.shop.service;

public interface MailSenderService {
    void sendMail(String them, String mailBody, String email);
}

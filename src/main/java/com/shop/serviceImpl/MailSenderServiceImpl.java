package com.shop.serviceImpl;

import com.shop.service.MailSenderService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailSenderServiceImpl implements MailSenderService {

    private final static String USERNAME = "taraskostsv@gmail.com";
    private final static String PASSWORD = "**********";

    @Async
    public void sendMail(String theme, String mailBody, String email) {
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return super.getPasswordAuthentication();
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(USERNAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(theme, "UTF-8");
            message.setText(mailBody);

            synchronized (this) {
                Transport.send(message);
            }

        }catch (MessagingException mex){
            mex.printStackTrace();
            System.out.println("You have some problems with connection!");
        }
    }
}

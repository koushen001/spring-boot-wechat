package com.cike.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-18 11:16
 **/
@Component
public class EmailUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String spring_mail_username;

    public void sendSimpleMail(String toEmail, String title, String content) {
        LOGGER.info("开始发送邮件，收件人：{}，邮件标题：{}，邮件内容：{}", toEmail, title, content);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(spring_mail_username);//发送者.
        message.setTo(toEmail);//接收者.
        message.setSubject(title);//邮件主题.
        message.setText(content);//邮件内容.
        mailSender.send(message);//发送邮件
    }

    public void sendHtmlMail(String toEmail, String title, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(spring_mail_username);
            helper.setTo(toEmail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

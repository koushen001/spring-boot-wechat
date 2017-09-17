package com.cike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-14 10:26
 **/
@Controller
public class IndexController {
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/email")
    @ResponseBody
    public String email(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("koushen001@163.com");//发送者.
        message.setTo("875569847@qq.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("这是邮件内容");//邮件内容.
        mailSender.send(message);//发送邮件
        return "SUCCESS";
    }
}

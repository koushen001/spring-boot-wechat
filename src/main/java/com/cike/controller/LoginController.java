package com.cike.controller;

import com.cike.common.MyConst;
import com.cike.config.WechatConfig;
import com.cike.entity.User;
import com.cike.service.UserService;
import com.cike.service.WechatService;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 9:39
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private WechatService wechatService;
    @Autowired
    private UserService userService;

    @RequestMapping("/wechat")
    public void wechat(HttpServletResponse response) {
        try {
            response.sendRedirect(WechatConfig.AUTHORIZE_URL
                    .replace("APPID", WechatConfig.APPID)
                    .replace("REDIRECT_URI", WechatConfig.AUTHORIZE_URL_REDIRECT_URI)
            );
        } catch (IOException e) {
            LOGGER.error("转发到微信授权页面出错：{}", e);
        }
    }

    @RequestMapping("/getCode")
    public String getCode(String code, HttpSession session, HttpServletRequest request) {
        LOGGER.info("微信返回code:{}", code);
        User user = wechatService.getUser(code);
        session.setAttribute(MyConst.CURRENT_USER, user);
        session.setAttribute(MyConst.PROJECT_PATH, request.getContextPath());
        return "redirect:/";
    }

    @RequestMapping("/index")
    public String index(HttpSession session, HttpServletRequest request) {
        User user = userService.getById(1L);
        session.setAttribute(MyConst.CURRENT_USER, user);
        session.setAttribute(MyConst.PROJECT_PATH, request.getContextPath());
        return "redirect:/";
    }
}
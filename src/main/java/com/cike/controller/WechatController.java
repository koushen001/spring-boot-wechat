package com.cike.controller;

import com.cike.common.MyConst;
import com.cike.entity.User;
import com.cike.util.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-14 9:08
 **/
@Controller
@RequestMapping("/wechat")
public class WechatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatController.class);

    @RequestMapping("/verify")
    @ResponseBody
    public String verify(String signature, String timestamp, String nonce, String echostr) {
        LOGGER.info("开始验证微信请求，参数：signature={},timestamp={},nonce={},echostr={}", signature, timestamp, nonce, echostr);
        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return "ERROR";
    }

}

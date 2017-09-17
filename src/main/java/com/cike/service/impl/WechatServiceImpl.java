package com.cike.service.impl;

import com.cike.bo.AccessTokenPO;
import com.cike.config.WechatConfig;
import com.cike.entity.User;
import com.cike.service.WechatService;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 9:45
 **/
@Service
public class WechatServiceImpl implements WechatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatServiceImpl.class);


    @Override
    public User getUser(String code) {
        AccessTokenPO accessToken = this.getAccessToken(code);
        String result = HttpUtil.get(WechatConfig.AUTHORIZE_URL_USERINFO.
                replace("ACCESS_TOKEN", accessToken.getAccess_token()).
                replace("OPENID", accessToken.getOpenid()));
        LOGGER.info("拉取用户信息(需scope为 snsapi_userinfo)返回数据：{}", result);
        User user = JSONUtil.toBean(JSONUtil.parseObj(result), User.class);
        return user;
    }

    @Override
    public AccessTokenPO getAccessToken(String code) {
        String result = HttpUtil.get(WechatConfig.AUTHORIZE_URL_ACCESS_TOKEN.
                replace("APPID", WechatConfig.APPID).
                replace("CODE", code).
                replace("SECRET", WechatConfig.APPSECRET));
        LOGGER.info("通过code换取网页授权access_token返回数据：{}", result);
        return JSONUtil.toBean(JSONUtil.parseObj(result), AccessTokenPO.class);
    }
}

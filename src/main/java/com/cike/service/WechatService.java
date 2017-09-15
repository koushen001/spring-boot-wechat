package com.cike.service;

import com.cike.bo.AccessTokenPO;
import com.cike.entity.User;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-15 9:45
 **/
public interface WechatService {

    User getUser(String code);

    AccessTokenPO getAccessToken(String code);
}

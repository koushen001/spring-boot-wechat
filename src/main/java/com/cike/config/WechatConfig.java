package com.cike.config;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-14 9:15
 **/
public class WechatConfig {
    public static final String DO_MAIN = "http://www.kouliang.site/";
    public static final String APPID = "wx08cb57911c39673c";
    public static final String APPSECRET = "714e5d3b5ba6de330c730b17dde4b7ed";
    public static final String TOKEN = "kou";
    public static final String AUTHORIZE_URL_REDIRECT_URI = DO_MAIN+"login/getCode";
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
    public static final String AUTHORIZE_URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static final String AUTHORIZE_URL_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}

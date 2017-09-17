package com.cike.util;

import com.cike.config.WechatConfig;
import com.cike.menu.Button;
import com.cike.menu.ClickButton;
import com.cike.menu.Menu;
import com.cike.menu.ViewButton;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-14 9:36
 **/
public class WechatUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatUtil.class);

    /**
     * 获取access_token
     */
    public static String getAccessToken() {
        String url = WechatConfig.ACCESS_TOKEN_URL.replace("APPID", WechatConfig.APPID).replace(
                "APPSECRET", WechatConfig.APPSECRET);
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result = HttpUtil.get(url);
        LOGGER.info("获取access_token接口返回数据：{}", result);
        String access_token = JSONUtil.parse(result).getByExp("access_token").toString();
        LOGGER.info("access_token：{}", access_token);
        return access_token;
    }

    /**
     * 组装菜单
     */
    public static Menu initMenu() {

//        String url = "http://www.kouliang.site";
        String url = "http://koushen001.imwork.net";

        Menu menu = new Menu();

        ViewButton button1 = new ViewButton();
        button1.setName("设备管理");
        button1.setType("view");
        button1.setUrl(url);

        ViewButton button2 = new ViewButton();
        button2.setName("个人中心");
        button2.setType("view");
        button2.setUrl(url);

        ClickButton button31 = new ClickButton();
        button31.setName("我要扫码");
        button31.setType("scancode_push");
        button31.setKey("21");

        ClickButton button32 = new ClickButton();
        button32.setName("我的位置");
        button32.setType("location_select");
        button32.setKey("22");

        Button button3 = new Button();
        button3.setName("小试牛刀");
        button3.setSub_button(new Button[]{button31, button32});

        menu.setButton(new Button[]{button1, button2, button3});
        return menu;
    }

    /**
     * 创建菜单
     */
    public static int createMenu(String accessToken) {
        String url = WechatConfig.CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
        Menu menu = initMenu();
        String result = HttpUtil.post(url, JSONUtil.toJsonStr(menu));
        LOGGER.info("创建菜单接口返回数据：{}", result);
        return 0;
    }

    public static void main(String[] args) {
        createMenu(getAccessToken());
    }
}

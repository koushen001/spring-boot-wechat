package com.cike.util;

import com.cike.config.WechatConfig;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class CheckUtil {
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        if (StringUtils.isEmpty(signature)||StringUtils.isEmpty(timestamp)||StringUtils.isEmpty(nonce)){
            return false;
        }
        String[] arr = new String[]{WechatConfig.TOKEN, timestamp, nonce};
        //排序
        Arrays.sort(arr);
        //生成字符串
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            String string = arr[i];
            content.append(string);
        }
        //sha1加密
        SHA1 sha1 = new SHA1();
        String temp = sha1.Digest(content.toString());
        return temp.equals(signature);
    }
}

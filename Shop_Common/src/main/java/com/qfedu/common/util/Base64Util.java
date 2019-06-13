package com.qfedu.common.util;

import java.util.Base64;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 17:43 2019/6/13
 * @ Description：64转换工具
 */
public class Base64Util {
    //转换为Base64
    public static String base64Enc(byte[] msg) {
        return Base64.getEncoder().encodeToString(msg);
    }
    //解码
    public static byte[] base64Dec(String msg) {
        return Base64.getDecoder().decode(msg);
    }
}

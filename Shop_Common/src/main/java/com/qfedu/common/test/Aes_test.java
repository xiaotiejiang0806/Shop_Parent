package com.qfedu.common.test;

import com.qfedu.common.util.EncryptionUtil;

import java.util.Map;

/**
 * @ Author     ：mmzs.
 * @ Date       ：Created in 20:39 2019/6/13
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class Aes_test {
    public static void main(String[] args) {
        /*String key = EncryptionUtil.createAESKEY();
        System.out.println(key);
        String s = EncryptionUtil.AESEnc(key, "123456");
        System.out.println(s);
        String s1 = EncryptionUtil.AESDec(key, s);
        System.out.println(s1);*/

        String pass = "123";
        Map<String, String> rsaKey = EncryptionUtil.createRSAKey();
        System.out.println(rsaKey);
        String s = EncryptionUtil.RSAEnc(rsaKey.get(EncryptionUtil.PRIVATEKEY), pass);
        System.out.println(s);
        String s1 = EncryptionUtil.RSADec(rsaKey.get(EncryptionUtil.PUBLICKEY), s);
        System.out.println(s1);
    }
}

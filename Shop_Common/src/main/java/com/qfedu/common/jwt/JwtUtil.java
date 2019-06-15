package com.qfedu.common.jwt;

import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.util.TimeUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:11 2019/6/14
 * 基于Jwt进行封装处理
 */
public class JwtUtil {

    /**
     *  生成token令牌
     * @param id
     * @param content
     * @return
     */
    public static String createJWT(String id,String content){
        SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder();
        builder.setId(id);
        builder.setSubject(content);//  subject
        builder.setIssuedAt(new Date());//  开始时间
        builder.setExpiration(TimeUtil.getMin(30));
        builder.signWith(algorithm,createKey());

        return builder.compact();
    }

    /**
     *  生成密钥
     * @return
     */
    private static SecretKey createKey(){
        byte[] bytes = ProjectConfig.JWTKEY.getBytes();
        SecretKeySpec keySpec = new SecretKeySpec(bytes, 0, bytes.length, "AES");
        return keySpec;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean checkJWT(String token){
        SecretKey key = createKey();
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 解析令牌
     * @param token
     * @return
     */
    public static String parseJWT(String token){
        SecretKey key = createKey();

        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return claims.getSubject();
        }catch (Exception e){
            return null;
        }
    }

    /**
     *  更新失效时间
     * @param token
     * @return
     */
    public static String updateJwt(String token){
        SecretKey key = createKey();

        try {
            SignatureAlgorithm algorithm = SignatureAlgorithm.HS256;
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            claims.setExpiration(TimeUtil.getMin(ProjectConfig.JWTTIME));
            claims.setIssuedAt(new Date());
            JwtBuilder builder = Jwts.builder();
            builder.addClaims(claims);
            builder.signWith(algorithm,createKey());
            return builder.compact();
        }catch (Exception e){
            return null;
        }
    }

   /* public static void main(String[] args) {
        String jwt = createJWT("10001", "{'name' : 'zhangsan','age':11}");
        System.out.println(jwt);

        boolean b = checkJWT(jwt);
        System.out.println(b);

        String s = parseJWT(jwt);
        System.out.println(s);
    }*/
}

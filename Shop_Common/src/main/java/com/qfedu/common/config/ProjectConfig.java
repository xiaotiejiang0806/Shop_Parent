package com.qfedu.common.config;

import java.util.HashMap;
import java.util.Map;

public class ProjectConfig {

    //  初始化积分
    public static final int INITSCORE = 50;
    //  初始化失效时间
    public static final int ENDDATE = 15;
    //  初始化购物车数量
    public static final int INITCOUNT = 50;

    //  短信发送模版id
    public static final String MSGMODELID = "165094";
    //  聚合短信keyid
    public static final String MSGKEYID = "de5e3795c8709b2dc4d8a4f99696530c";

    //邮箱相关配置
    public static final String EMAIL="hy_oldtime@163.com";
    public static final String EMAILPASS="Dai123";
    public static final String EMAILHOST="smtp.163.com";

    //Redis信息
    public static final String REDISHOST="47.100.180.226";
    public static final int REDISPORT=6380;
    public static final String REDISPASS="qfjava";

    //短信相关
    //Redis常用的key的设置
    public static final String SMSPRELIMIT="smspre:";//记录手机号一分钟只能发一次
    public static final String SMSPREDAY="smsday:";//记录手机号一天只能发20条
    public static final String SMSCODE="smscode:";//

    public static Map<Integer,String> projects;
    static {
        projects=new HashMap<>();
        projects.put(10001,"邻家邦");

    }
    //激活地址
    public static final String ACTIVEURL="";
    //aes加密的密钥
    public static final String AESKEYACTIVECODE="27Ir+iOeBTEsIM52btL7VQ==";

    //密码加密 采用RSA
    public static final String PASSRSAPUB ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALN4iAMA5E4mES+aCz91CFtFUNzMBefeKB1/0qWo8J7BNAshZId8HONO1KSDuNWxeeD1VC8Cg0CNbt9pDWU9cKcCAwEAAQ";
   public static final String PASSRSAPRI= "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAs3iIAwDkTiYRL5oLP3UIW0VQ3MwF594oHX/SpajwnsE0CyFkh3wc407UpIO41bF54PVULwKDQI1u32kNZT1wpwIDAQABAkAaV1+HKVNZEQdGuFJcTv4Z/1N+BMf9H0M+CSvOurwOYMdsGggaahPUvg5MAq7hrIjTYe3wEe3rVote+FG6a+tRAiEA+d9/y0tdn9dNSgZvQTk/dwxrdKVCU/fW4eK+ssE71y8CIQC33xqbYPKzsLJIsWApCX+Y9kPX347KFywPKz+IlVMgCQIhANpI6TcLq8qLJ7XXUTHFdS/m5aiNBhicllfW4Yj/Tet5AiB2lQI51wpvbLNuQka78I5D/f6/CES0fMFDfybYVUVo0QIhALY8Dy6AT7KK0sIWDE+siGIW4+lsMqBKFBhcgX1266TQ";

}

package com.qfedu.shop.server.user.config;

import com.qfedu.common.util.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 19:39 2019/6/13
 */
@Configuration
public class RedisConfig {
    @Bean
    public JedisUtil creatJedis(){
        return JedisUtil.getInstance();
    }
}

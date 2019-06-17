package com.qfedu.shop.resouce.config;

import com.qfedu.shop.resouce.util.OssUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:10 2019/6/16
 * @ Description：${description}
 */
@Configuration
public class OssConfig {
    @Bean
    public OssUtil creatOss(){
        return new OssUtil();
    }
}

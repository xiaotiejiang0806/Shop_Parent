package com.qfedu.shop.server.config;

import com.qfedu.common.util.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IdGeneratorConfig {
    @Bean
    public IdGenerator createIG(){
        return new IdGenerator();
    }
}

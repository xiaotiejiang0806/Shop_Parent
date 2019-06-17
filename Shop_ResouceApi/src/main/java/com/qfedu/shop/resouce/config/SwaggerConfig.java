package com.qfedu.shop.resouce.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    public ApiInfo createA(){
        ApiInfo info=new ApiInfoBuilder().title("小商店-资源上传平台").
                contact( new Contact("Demos","http://1000phone.com","hy_oldtime@163.com")).
                description("实现一个小商店项目资源上传的数据接口").build();
        return info;
    }
    @Bean//创建对象  修饰方法 方法的返回值必须是引用类型  对象存储在IOC容器
    public Docket createDocket(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2).apiInfo(createA()).select().
                apis(RequestHandlerSelectors.basePackage("com.qfedu.shop.resouce.controller")).build();
        return docket;

    }
}

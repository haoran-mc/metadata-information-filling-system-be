package com.metadata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("全部API") //分组名，每分一组新建一个docket就行
                .enable(true) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.metadata.controller"))
                // // 配置如何通过path过滤,即这里只扫描请求以/user开头的接口
                // .paths(PathSelectors.ant("/users/**"))
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("刘浩然", //联系人
                " ", " "); //联系链接 邮箱
        return new ApiInfo(
                "Swagger", // 标题
                "Metadata 的 API", // 描述
                "v1.0", // 版本
                " ", // 组织链接
                contact, // 联系人信息
                "无许可", // 许可
                " ", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}

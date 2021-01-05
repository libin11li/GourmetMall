package com.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author li
 * description:
 * date: 2021/1/5
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket login() {
        return docket("测试", "com.mall.api");
    }

    public Docket docket(String groupName, String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                // 配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                // 配置接口过滤规则
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("description")
                .license("license")
                .licenseUrl("licenseUrl")
                .termsOfServiceUrl("termsOfServiceUrl")
                .contact(new Contact("name", "url", "email"))
                .version("version")
                .build();
    }
}
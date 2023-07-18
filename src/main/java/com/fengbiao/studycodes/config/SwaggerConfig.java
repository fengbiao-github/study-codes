package com.fengbiao.studycodes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        Profiles profiles = Profiles.of("dev");
        return new Docket(DocumentationType.SWAGGER_2).enable(environment.acceptsProfiles(profiles)) // swagger开关
                .apiInfo(apiInfo()).groupName("分组").select()
                .apis(RequestHandlerSelectors.basePackage("com.fengbiao.studycodes.controller") // 扫描指定包
                ).build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("接口文档").description("接口文档描述信息").version("0.0.1-SNAPSHOT").build();
    }
}

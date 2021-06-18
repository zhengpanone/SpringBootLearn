package com.zp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/23 14:17.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */

@Configuration // 这是一个配置类
@EnableSwagger2 // 开启Swagger2自动注解
public class Swagger2Configuration {
    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.zp";
    public static final String VERSION = "1.0.0";

    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Doc title")
                .description("Api Doc Description")
                .version(VERSION)
                .termsOfServiceUrl("http://www.baidu.com")// 设置文档的License信息->1.3 License information
                .build();
    }
}

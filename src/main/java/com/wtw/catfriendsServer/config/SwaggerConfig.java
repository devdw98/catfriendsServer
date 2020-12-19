package com.wtw.catfriendsServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

        @Bean
        public Docket swaggerApi(){
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
                    .apis(RequestHandlerSelectors.basePackage("com.wtw.catfriendsServer.controller")) //패키지 안의 controller내용을 읽어 mapping 된 resources들을 문서화
                    .paths(PathSelectors.ant("/test/**")) //v1로 시작하는 resources만 문서화
                    .build()
                    .useDefaultResponseMessages(false); //기본으로 세팅되는 200, 401, 403, 404 메세지 표시하지 않음
        }

        private ApiInfo swaggerInfo(){
            return new ApiInfoBuilder().title("Spring API Study")
                    .description("앱 개발 시 사용되는 서버 API에 대한 연동 문서 연습")
                    .license("dowon").licenseUrl("https://github.com/devdw98")
                    .version("1").build();
        }

}

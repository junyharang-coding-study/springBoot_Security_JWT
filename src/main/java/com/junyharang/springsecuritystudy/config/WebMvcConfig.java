package com.junyharang.springsecuritystudy.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();

        resolver.setCharset("UTF-8");   // 내가 만든 View에 Encoding을 "UTF-8"로 설정
        resolver.setContentType("text/html; charset=UTF-8"); // View에서 던지는 Data Type은 "text/html(html 파일형식); charset=UTF-8(html File은 UTF-8)" 이다.
        resolver.setPrefix("classpath:/templates/");    // classpath는 /src/main/resources 이고, 그 밑에 templates 경로를 Prefix로 설정
        resolver.setSuffix(".html");    // .html File을 .mustache로 인식하게 설정

        registry.viewResolver(resolver);    // registry를 사용하여 ViewResolver를 등록하는데, 위에 설정한 내용을 가지고 등록
    } // configureViewResolvers(ViewResolverRegistry registry) 끝
} // class 끝

package com.junyharang.springsecuritystudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // view를 반환하겠다는 의미
public class IndexController {

    @GetMapping({"","/"}) public String index() {
        // 머스태치 기본폴더 /src/main/resources/
        // view resolver 설정 : templates (prefix), .mustache(suffix) -> 생략 가능
        // application.properties, .yml 등에 등록 안 해줘도 의존성 등록 해 주면 위와 같은 경로가 기본적으로 등록된다.
        return "index"; // /src/main/resources/templates/index.mustache를 기본적으로 찾게 되어있다.
    } // index() 끝

} // class 끝

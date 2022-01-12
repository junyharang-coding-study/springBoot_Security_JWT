package com.junyharang.springsecuritystudy.controller;

import com.junyharang.springsecuritystudy.model.Member;
import com.junyharang.springsecuritystudy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // view를 반환하겠다는 의미
public class IndexController {

    @Autowired private MemberRepository memberRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @GetMapping({"","/"}) public String index() {
        // 머스태치 기본폴더 /src/main/resources/
        // view resolver 설정 : templates (prefix), .mustache(suffix) -> 생략 가능
        // application.properties, .yml 등에 등록 안 해줘도 의존성 등록 해 주면 위와 같은 경로가 기본적으로 등록된다.
        return "index"; // /src/main/resources/templates/index.mustache를 기본적으로 찾게 되어있다.
    } // index() 끝

    @GetMapping("/user") public @ResponseBody String user() {
        return "user";
    } // user() 끝

    @GetMapping("/admin") public @ResponseBody String admin() {
        return "admin";
    } // admin() 끝

    @GetMapping("/manager") public @ResponseBody String manager() {
        return "manager";
    } // manager() 끝

    // 기본적으로 스프링 시큐리티는 해당 URI로 오면 이미 만들어진 Login Page를 보여주는데, SeuciryConfig 파일로 WebSecurityConfigurerAdapter를 상속 받아 구현하면 해당 기능이 사라진다.
    @GetMapping("/login/form") public String loginForm() {
        return "loginForm";
    } // login() 끝

    @GetMapping("/join/form") public String joinForm() {
        return "joinForm";
    } // login() 끝

    @PostMapping("/join") public String join(Member member) {
        System.out.println("회원 가입한 회원의 정보 : " + member.toString());
        member.setRole("ROLE_USER");

        String rawPWD = member.getPassword();
        String encPWD = passwordEncoder.encode(rawPWD);
        member.setPassword(encPWD);

        memberRepository.save(member);
        return "redirect:/login/form";  // /login/form으로 리다이렉트 해준다.
    } // join() 끝

} // clas끝 끝

package com.junyharang.springsecuritystudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록하기 위해 사용
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // Method에 @Bean을 붙히면 해당 Method의 반환되는 객체를 IoC로 등록해 준다.
    @Bean public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } // passwordEncoder() 끝

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                // ADMIN과 MANAGER 권한이 있는 사람만 해당 URI 접근 허용
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                // ADMIN권한이 있는 사람만 해당 URI 접근 허용
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                // 위의 인가처리 외에 모든 접근을 허용 한다.
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login/form");
    } // onfigure(HttpSecurity http) 끝

} // class 끝

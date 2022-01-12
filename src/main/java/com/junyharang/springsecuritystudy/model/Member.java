package com.junyharang.springsecuritystudy.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor @ToString @Setter
@Entity public class Member extends BaseDateTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    private String userName;
    private String password;
    private String email;
    private String role;    // ROLE_USER, ROLE_ADMIN, ROLE_MANAGER

} // class 끝

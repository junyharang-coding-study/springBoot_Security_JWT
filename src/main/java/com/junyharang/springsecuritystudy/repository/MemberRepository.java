package com.junyharang.springsecuritystudy.repository;

import com.junyharang.springsecuritystudy.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
} // class 끝

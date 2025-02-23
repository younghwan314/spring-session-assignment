package com.example.springsessionassignment.member.repository;

import com.example.springsessionassignment.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

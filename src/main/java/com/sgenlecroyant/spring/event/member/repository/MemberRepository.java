package com.sgenlecroyant.spring.event.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.spring.event.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

}

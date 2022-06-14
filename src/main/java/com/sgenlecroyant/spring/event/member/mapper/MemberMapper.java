package com.sgenlecroyant.spring.event.member.mapper;

import org.springframework.stereotype.Component;

import com.sgenlecroyant.spring.event.member.api.request.MemberRequest;
import com.sgenlecroyant.spring.event.member.entity.Member;

@Component
public class MemberMapper {
	
	public Member mapToMember(MemberRequest memberRequest) {
		Member member = new Member(memberRequest.getFirstName(), memberRequest.getLastName(), memberRequest.getEmail());
		return member;
	}

}

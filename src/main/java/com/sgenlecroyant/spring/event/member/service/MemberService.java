package com.sgenlecroyant.spring.event.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.spring.event.member.action.OnMemberActionDef;
import com.sgenlecroyant.spring.event.member.api.request.MemberRequest;
import com.sgenlecroyant.spring.event.member.entity.Member;
import com.sgenlecroyant.spring.event.member.repository.MemberRepository;

@Service
public class MemberService implements OnMemberActionDef{
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member saveMember(MemberRequest memberRequest) {
		
		return this.memberRepository.save(null);
	}

	@Override
	public Member fetchMemberById(String id) {
		
		return this.memberRepository.findById(id).get();
	}

	@Override
	public void deleteMemberById(String id) {
		this.memberRepository.deleteById(id);
	}

	@Override
	public void updateMember(String id, MemberRequest memberRequest) {
		
	}
	

}

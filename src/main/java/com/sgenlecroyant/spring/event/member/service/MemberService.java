package com.sgenlecroyant.spring.event.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.spring.event.member.action.OnMemberActionDef;
import com.sgenlecroyant.spring.event.member.api.request.MemberRequest;
import com.sgenlecroyant.spring.event.member.api.response.MemberResponse;
import com.sgenlecroyant.spring.event.member.entity.Member;
import com.sgenlecroyant.spring.event.member.mapper.MemberMapper;
import com.sgenlecroyant.spring.event.member.repository.MemberRepository;

@Service
public class MemberService implements OnMemberActionDef{
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Member saveMember(MemberRequest memberRequest) {
		Member member = this.memberMapper.mapToMember(memberRequest);
		return this.memberRepository.save(member);
	}

	@Override
	public Member fetchMemberById(String id) {
		MemberResponse memberResponse = new MemberResponse();
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

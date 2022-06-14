package com.sgenlecroyant.spring.event.member.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public MemberResponse fetchMemberById(String id) {
		Member member = this.memberRepository.findById(id).get();
		MemberResponse memberResponse = new MemberResponse(member.getFirstName(), member.getLastName());
		return memberResponse;
	}

	@Override
	public void deleteMemberById(String id) {
		this.memberRepository.deleteById(id);
	}

	@Override
	public MemberResponse updateMember(String id, MemberRequest memberRequest) {
		Optional<Member> fetchedMember = this.memberRepository.findById(id);
		Member member = null;
		if(fetchedMember.isPresent()) {
			Member realMember = fetchedMember.get();
			member = new Member(realMember.getFirstName(), realMember.getLastName(), realMember.getEmail());
			member.setId(realMember.getId());
			
		}
		return new MemberResponse(member.getFirstName(), member.getLastName());
	}

	@Override
	public List<MemberResponse> fetchMembers() {
		
				List<MemberResponse> memberResponses = this.memberRepository.findAll()
					.stream()
					.map(this.memberMapper::mapToMemberResponse)
					.collect(Collectors.toList());
		return memberResponses;
	}
	

}

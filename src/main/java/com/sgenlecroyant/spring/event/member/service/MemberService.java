package com.sgenlecroyant.spring.event.member.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.spring.event.events.MemberRegistrationEvent;
import com.sgenlecroyant.spring.event.events.publisher.AppEventPublisher;
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
	
	@Autowired
	private AppEventPublisher appEventPublisher;

	@Override
	public Member saveMember(MemberRequest memberRequest) {
		Member member = this.memberMapper.mapToMember(memberRequest);
		member.setId(UUID.randomUUID().toString().replace("-", ""));
		this.appEventPublisher.publish(new MemberRegistrationEvent(this, member));
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
			member = new Member(memberRequest.getFirstName(), memberRequest.getLastName(), memberRequest.getEmail());
			member.setId(realMember.getId());
			this.memberRepository.save(member);
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

package com.sgenlecroyant.spring.event.member.action;

import java.util.List;

import com.sgenlecroyant.spring.event.member.api.request.MemberRequest;
import com.sgenlecroyant.spring.event.member.api.response.MemberResponse;
import com.sgenlecroyant.spring.event.member.entity.Member;

public interface OnMemberActionDef {
	
	public Member saveMember(MemberRequest memberRequest);
	public MemberResponse fetchMemberById(String id);
	public void deleteMemberById(String id);
	public MemberResponse updateMember(String id, MemberRequest memberRequest);
	
	public List<MemberResponse> fetchMembers();

	
}

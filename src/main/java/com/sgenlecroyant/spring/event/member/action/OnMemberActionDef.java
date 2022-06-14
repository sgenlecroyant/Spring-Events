package com.sgenlecroyant.spring.event.member.action;

import com.sgenlecroyant.spring.event.member.api.request.MemberRequest;
import com.sgenlecroyant.spring.event.member.entity.Member;

public interface OnMemberActionDef {
	
	public Member saveMember(MemberRequest memberRequest);
	public Member fetchMemberById(String id);
	public void deleteMemberById(String id);
	public void updateMember(String id, MemberRequest memberRequest);

	
}

package com.sgenlecroyant.spring.event.member.action;

import com.sgenlecroyant.spring.event.member.entity.Member;

public interface OnMemberActionDef {
	
	public Member saveMember(Member member);
	public Member fetchMemberById(String id);
	public void deleteMemberById(String id);
	public void updateMember(String id, Member member);

}

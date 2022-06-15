package com.sgenlecroyant.spring.event.events;

import org.springframework.context.ApplicationEvent;

import com.sgenlecroyant.spring.event.member.entity.Member;

@SuppressWarnings("serial")
public class MemberRegistrationEvent extends ApplicationEvent{
	
	private Member member;
	
	public MemberRegistrationEvent(Object source, Member member) {
		super(source);
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}

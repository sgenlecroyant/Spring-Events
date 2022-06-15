package com.sgenlecroyant.spring.event.events.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.spring.event.events.MemberRegistrationEvent;
import com.sgenlecroyant.spring.event.member.entity.Member;

@Component
public class MemberRegistrationEventListener implements ApplicationListener<MemberRegistrationEvent>{

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void onApplicationEvent(MemberRegistrationEvent event) {
		
		Member registeredMember = event.getMember();
		this.logger.info("New Member Got Registered with FIrstName: {}, and LastName: {}", registeredMember.getFirstName(), registeredMember.getLastName());
	}

}

package com.sgenlecroyant.spring.event.events.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.spring.event.events.MemberRegistrationEvent;

@Component
public class AnotherMemberRegistrationEventListner {
	
	
	@EventListener(classes = {MemberRegistrationEvent.class})
	public void listenRegistrationEvent(MemberRegistrationEvent event) {
		System.out.println("another listner ... has got the info ..." +event.getMember().getFirstName());
	}

}

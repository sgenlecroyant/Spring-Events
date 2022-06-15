package com.sgenlecroyant.spring.event.events.publisher;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppEventPublisher {
	
	private ApplicationEventPublisher applicationEventPublisher;
	
	public <T extends ApplicationEvent> void publish(T appEvent){
		this.applicationEventPublisher.publishEvent(appEvent);
	}

}

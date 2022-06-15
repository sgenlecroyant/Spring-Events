package com.sgenlecroyant.spring.event.events.publisher;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AppEventPublisher {
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Async
	public <T extends ApplicationEvent> void publish(T appEvent){
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.applicationEventPublisher.publishEvent(appEvent);
	}

}

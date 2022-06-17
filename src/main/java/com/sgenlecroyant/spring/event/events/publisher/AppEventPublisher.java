package com.sgenlecroyant.spring.event.events.publisher;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.sgenlecroyant.spring.event.events.MemberRegistrationEvent;
import com.sgenlecroyant.spring.event.mail.Email;
import com.sgenlecroyant.spring.event.mail.EmailSender;

@Component
public class AppEventPublisher {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	private EmailSender emailSender;
	
	@Value(value ="${app.mail.destination.address}")
	private String destinationEmailAddress;

	@Autowired
	public AppEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Async
	public <T extends MemberRegistrationEvent> void publish(T appEvent) {
		try {
			TimeUnit.SECONDS.sleep(Duration.ofSeconds(1).toSeconds());
			this.emailSender.sendEmail(new Email(destinationEmailAddress, "Hello, thanks for registering for the big  ..."));
			this.applicationEventPublisher.publishEvent(appEvent);
		} catch (InterruptedException | ApplicationContextException e) {
			this.logger.error("error publishing event: {}, due to {}", e.getClass().getSimpleName(), e.getMessage());
		}

	}

}

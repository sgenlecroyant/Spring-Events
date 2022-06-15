package com.sgenlecroyant.spring.event.events;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class EventConfig {
	
	@Bean(name = AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
	public ApplicationEventMulticaster getApplicationEventMulticaster() {
		
		SimpleApplicationEventMulticaster applicationEventMulticaster = 
				new SimpleApplicationEventMulticaster();
		
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor("Event-Publishing-Thread");
		taskExecutor.setConcurrencyLimit(-1);
		taskExecutor.setThreadPriority(5);
		applicationEventMulticaster.setTaskExecutor(taskExecutor);
		
		return applicationEventMulticaster;
		
	}

}

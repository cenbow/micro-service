package edu.ustc.server.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class StartedEventApplicationListener implements ApplicationListener<ApplicationStartedEvent> {
	
	private Logger logger = LoggerFactory.getLogger(StartedEventApplicationListener.class);
	
	@SuppressWarnings("deprecation")
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		
		SpringApplication app = event.getSpringApplication();
        app.setShowBanner(false);
        
		logger.info("1 spring boot启动, StartedEventApplicationListener...");
	}
}

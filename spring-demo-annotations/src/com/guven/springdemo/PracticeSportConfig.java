package com.guven.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {

	
	
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService ();
	}
	@Bean
	public Coach wrestlingCoach(){
		WrestlingCoach myWrestlingCoach= 
				new WrestlingCoach(sadFortuneService());
		return myWrestlingCoach;
	}
}

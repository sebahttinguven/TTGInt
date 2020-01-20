package com.guven.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	
	@PostConstruct
	public void doMyStartupStuff(){
		//System.out.println(">>HappyFortuneService: inside postConstrucct");
	}
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day";
	}

}

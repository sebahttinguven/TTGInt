package com.guven.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
private FortuneService fortuneService;

@Value("${foo.email}")
private String email;

@Value("${foo.team}")
private String team;

public SwimCoach(FortuneService theFortuneService) {
	fortuneService=theFortuneService;
}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as a awrm up";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	
	
}

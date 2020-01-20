package com.guven.springdemo;

public class WrestlingCoach implements Coach {

 private FortuneService fortunservice;
 
 
 
 public WrestlingCoach(FortuneService theFortuneService) {
	 fortunservice=theFortuneService;
}
	
	@Override
	public String getDailyWorkOut() {
		
	return	"do some practice";
	}

	@Override
	public String getDailyFortune() {
		
		return fortunservice.getFortune();
	}

	
	
}

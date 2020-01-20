package com.guven.springdemo;

public class BaseballCoach implements Coach{

	private FortuneService fortuneService;
	
	
	public BaseballCoach(){
		
	}
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	
	
	@Override
	public String getDailyWorkOut(){
		
		return "Spend 30 minuts on batting prectice";
	}

	@Override
	public String getDailyFortune() {


		return fortuneService.getFourtune();
	}
	
}

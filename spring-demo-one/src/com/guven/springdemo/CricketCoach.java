package com.guven.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String email;
	
	private String team;
	
	public  CricketCoach() {
		System.out.println("İnside CricketCoach Constructer method");
	}
	

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("İnside CricketCoach setter setFortuneService method");
		this.fortuneService = fortuneService;
	}

	
	
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice Bowling 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFourtune();
	}

}

package com.guven.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
public TrackCoach() {
		
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
	
		return "Run hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do it"+ fortuneService.getFourtune();
	}
	
	//application contexte bean içinde init method olarak ayarlandı.
	public void doMyStartupStuff(){
		System.out.println("TrackCoach:inside method doMyStartupStuff");
		
	}
	//application contexte bean içinde destroy method olarak ayarlandı.
	public void doMyCleanupStuff(){
		System.out.println("TrackCoach:inside method doMyCleanupStuff");
		
	}
	

}

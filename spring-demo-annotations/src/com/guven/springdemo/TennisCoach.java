package com.guven.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("readRandomFortuneFileService") // FortuneService birden fazla
												// sınıfla implement edildiği
												// için
	// @Qualifier Annotation aracılığıyla hangi class ile @Autowired kurması
	// gerektiğini belirliyor
	private FortuneService fortunService;

	public TennisCoach() {
		System.out.println("TennisCoach: default constructor");
	}

	
	/*  @Autowired public TennisCoach(FortuneService theFortunService) {
	  fortunService=theFortunService; }
	 
	 * @Autowired public void setFortunService(FortuneService fortunService) {
	 * this.fortunService = fortunService; }
	 */

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortunService.getFortune();
	}

}

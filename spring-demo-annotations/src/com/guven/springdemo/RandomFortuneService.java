package com.guven.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//Create an array string
	
	public RandomFortuneService() {
		// TODO Auto-generated constructor stub
	}
	
	private String[] data={
			"Bawere of the wolf",
			"Diligence is the mother of good luck",
			"The journey is the rewrd"
	};
	private Random myRandom= new Random();
	
	@Override
	public String getFortune() {
		int index=myRandom.nextInt(data.length);
		String theFortune=data[index];
		return theFortune;
	}

}

package com.guven.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		Coach theCoach= new  BaseballCoach();
		
		Coach theCoach1= new  TrackCoach();
		System.out.println(theCoach.getDailyWorkOut());

	}

}

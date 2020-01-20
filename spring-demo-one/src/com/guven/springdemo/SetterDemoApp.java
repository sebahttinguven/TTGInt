package com.guven.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		// Load the spring configuration file(applicationcontext)

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrive bean from spring container

		CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// calls method on the bean
		System.out.println( theCricketCoach.getDailyFortune());
		System.out.println( theCricketCoach.getDailyWorkOut());
		
		
		//Call our new method to get the literatür value
		System.out.println( theCricketCoach.getEmail());
		System.out.println( theCricketCoach.getTeam());
		
		// close context
		context.close();
	}

}

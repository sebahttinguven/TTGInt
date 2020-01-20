package com.guven.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from spring container
		Coach theCoach = context.getBean("swimCoach", Coach.class);

		// call a method on theg bean
		System.out.println(theCoach.getDailyWorkOut());

		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close context
		context.close();
	}

}

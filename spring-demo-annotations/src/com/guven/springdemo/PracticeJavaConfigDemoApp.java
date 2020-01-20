package com.guven.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// read spring config java class
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		// get the bean from spring container
		Coach theCoach = context.getBean("wrestlingCoach", Coach.class);

		// call a method on theg bean
		System.out.println(theCoach.getDailyWorkOut());

		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close context
		context.close();
	}

}

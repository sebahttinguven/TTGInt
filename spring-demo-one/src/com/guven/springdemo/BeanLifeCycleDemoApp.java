package com.guven.springdemo;

import javax.sound.midi.Track;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//Load the Spring Confugration file
		ClassPathXmlApplicationContext context= new   ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retriew bean from spring container
		Coach theCoach= context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkOut());
		
		//Close the Context
		context.close();
	}

}

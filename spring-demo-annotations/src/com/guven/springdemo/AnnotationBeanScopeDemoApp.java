package com.guven.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Load Spring Config File
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

		//retrieve bena from spring container
		Coach theCoach =context.getBean("tennisCoach",Coach.class);
	
	
	}

}

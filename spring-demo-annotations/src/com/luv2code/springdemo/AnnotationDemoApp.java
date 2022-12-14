package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		//call a method on the bean 
		System.out.println(theCoach.getdailyWorkout());
		System.out.println(theCoach.getdailyFortune());
		
		// close the context
		context.close();

	}

}

package com.luv2code.springdemo;

public class RandomFortuneService implements FortuneService {

	private String[] tableauFortune = {"Today is your lucky day",
			"today is NOOOOOT your lucky day",
			"today is just normal, nothing special",
			"today is the worst day of your life",
			"you gonna dye today, sorry bro" };
	
	@Override
	public String getFortune() {
	//private index = 
	int index = (int)(Math.random() * tableauFortune.length);
	return tableauFortune[index];
	}

}

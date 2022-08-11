package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PetanqueCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getdailyWorkout() {
		return "3h of elbow raising work";
	}

	@Override
	public String getdailyFortune() {
		return fortuneService.getFortune();
	}

}

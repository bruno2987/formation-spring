package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
//@Scope("prototype")    //  <-- annotation pour gérer le scope du composant
public class TennisCoach implements Coach {
	
	
	// Ici on ajoute l'anotation Autowired directement sur l'attribut pour que l'injection de dépendance se fasse à ce niveau
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		//System.out.println(">> TennisCoach: inside default construtor");
	}

	// Ci dessous un exemple d'injection de dépendance via une méthode setter. cette partie est commenté pour tester
	// l'injection de dépendance directement dans les attributs
	/*
	// Define a setter method
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService");
		fortuneService = theFortuneService;
	}
	*/
	
	
	// Ci dessous un exemple d'injection de dépendance via un constructeur
	// ATTENTION, si on veut utiliser @Qualifier pour les constructeur, il faut ajouter l'annotation directement dans le
	// constructeur ainsi: public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) { ...
	/*
	@Autowired
	public TennisCoach(FortuneService theFortune) {
		fortuneService = theFortune;
	}
	*/

	@Override
	public String getdailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getdailyFortune() {
		return fortuneService.getFortune();
	}
	
	//define my init method
	@PostConstruct  // <-- annotation pour les méthodes qui doivent se lancer au moment de la construction du Bean
	public void doMyStartupStuff() {
		System.out.println("tennisCoach: Inside of doMyStartupStuff");
	}
	
	//define my destroy method
	@PreDestroy  // <-- annotation pour les méthodes qui doivent se lancer au moment de la destruction du Bean
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach : inside of doMyCleanupStuff");
	}
	// ATTENTION, les méthode Predestroy ne sont pas lancées dans le cas de Bean dont le scope est "prototype"
	// c'est le cas aussi pour les méthodes configuré dans le fichier xml (destroy-method) 

}

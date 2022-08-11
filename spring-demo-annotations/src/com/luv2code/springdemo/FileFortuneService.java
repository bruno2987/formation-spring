package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileFortuneService implements FortuneService {
	
	private ArrayList<String> liste = new ArrayList<String>();
	private Random myRandom = new Random();
	
	public FileFortuneService() {
		System.out.println(">> inside fileFortuneService constructor");
		try {
			FileReader fr = new FileReader("D:\\exo_Spring.txt");
			var reader = new BufferedReader(fr);
			
			String lineRead;
			
			while ((lineRead = reader.readLine()) != null) {
			    liste.add(lineRead);
			};
			reader.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(liste.size());
		return liste.get(index);
	}

}

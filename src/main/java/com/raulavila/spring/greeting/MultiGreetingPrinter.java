package com.raulavila.spring.greeting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MultiGreetingPrinter {

	@Autowired
	private List<GreetingService> greetingServices;
	
	public void printGreeting() {
		for(GreetingService greetingService : greetingServices) {
			System.out.println(greetingService.getGreeting());
		}
		
	}
	
}

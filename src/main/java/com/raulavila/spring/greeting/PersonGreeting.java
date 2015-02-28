package com.raulavila.spring.greeting;

import org.springframework.core.Ordered;

public class PersonGreeting implements GreetingService, Ordered {

	private String personName;
	
	private int order;
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String getGreeting() {
		return "Hello "+personName+"!";
	}

	@Override
	public int getOrder() {
		return order;
	}

}

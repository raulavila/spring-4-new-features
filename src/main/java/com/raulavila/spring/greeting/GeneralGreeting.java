package com.raulavila.spring.greeting;

import org.springframework.core.Ordered;

public class GeneralGreeting implements GreetingService, Ordered{

	private int order;
	
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String getGreeting() {
		return "Hello everybody!";
	}

	@Override
	public int getOrder() {
		return order;
	}

}

package com.raulavila.spring.context;

import com.raulavila.spring.greeting.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.raulavila.spring.stores.Store;

public class AnnotationConfigApp {
	
	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(MyApplicationContext.class);

		Store<Integer> intStore = (Store<Integer>) context.getBean("intStore");
		intStore.add(2);
		System.out.println(intStore.getFirst());

		GreetingService helloWorld = (GreetingService) context.getBean("helloWorld");
		System.out.println(helloWorld.getGreeting());
	}
}

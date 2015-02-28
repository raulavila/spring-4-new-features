package com.raulavila.spring.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderQualifiersApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans-order-qualifiers.xml");
 
		MultiGreetingPrinter printer = (MultiGreetingPrinter) context.getBean("multiGreetingPrinter");
		printer.printGreeting();
		
		
	}

}

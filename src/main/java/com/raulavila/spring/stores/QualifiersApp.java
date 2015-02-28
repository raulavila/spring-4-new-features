package com.raulavila.spring.stores;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifiersApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans-qualifiers.xml");
 
		StringShop shop = context.getBean(StringShop.class);
		
		shop.addToStore("red table");
		
		System.out.println(shop.showFirst());
	}
	
	
}

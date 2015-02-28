package com.raulavila.spring.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StringShop {

	@Autowired
	private Store<String> store;
	
	public void addToStore(String item) {
		store.add(item);
	}
	
	public String showFirst() {
		return store.getFirst();
	}

}

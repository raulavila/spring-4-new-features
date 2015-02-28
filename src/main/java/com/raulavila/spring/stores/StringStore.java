package com.raulavila.spring.stores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StringStore implements Store<String>{

	private List<String> items = new ArrayList<>();
	
	@Override
	public void add(String item) {
		items.add(item);
	}

	@Override
	public String getFirst() {
		if(items.isEmpty())
			throw new IllegalStateException("Store is empty");
		
		return items.get(0);
	}
}

package com.raulavila.spring.stores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class IntStore implements Store<Integer>{
	private List<Integer> items = new ArrayList<>();
	
	@Override
	public void add(Integer item) {
		items.add(item);
	}

	@Override
	public Integer getFirst() {
		if(items.isEmpty())
			throw new IllegalStateException("Store is empty");
		
		return items.get(0);
	}
	
	
}

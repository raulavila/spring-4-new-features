package com.raulavila.spring.stores;

public interface Store<T> {
	
	void add(T item);
	T getFirst();
	
}

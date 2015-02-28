package com.raulavila.spring.mvc.rest;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestController4 {

	@RequestMapping("/greeting4")
	public String getGreeting(ZoneId zoneId) {
		return "Hello world - Spring 4. TimeZone: "+zoneId;
	}
	
	@RequestMapping("/items4")
	public List<String> getItems() {
		return Arrays.asList("item1 - Spring 4","item2 - Spring 4");
	}
}

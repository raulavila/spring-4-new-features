package com.raulavila.spring.mvc.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController32 {

	@RequestMapping("/greeting32")
	public @ResponseBody String getGreeting() {
		return "Hello world - Spring 32";
	}
	
	@RequestMapping("/items32")
	public @ResponseBody List<String> getItems() {
		return Arrays.asList("item1 - Spring 32","item2 - Spring 32");
	}
}

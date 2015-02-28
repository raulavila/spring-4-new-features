package com.raulavila.spring.context;

import com.raulavila.spring.greeting.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.raulavila.spring.stores.IntStore;
import com.raulavila.spring.stores.Store;

@Configuration
@ComponentScan
public class MyApplicationContext {

	@Bean(name="intStore")
	@Description("Description of the bean")
	public Store<Integer> getIntStore() {
		return new IntStore();
	}
	
	@Bean(name="helloWorld")
	@Conditional(NoGreetingServiceDefined.class)
	public GreetingService createGreetingService(){
		return new GreetingService() {
			@Override
			public String getGreeting() {
				return "Hello world!!";
			}
		};
	}
	
}



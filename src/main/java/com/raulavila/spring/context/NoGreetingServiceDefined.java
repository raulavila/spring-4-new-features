package com.raulavila.spring.context;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.raulavila.spring.greeting.GreetingService;

public class NoGreetingServiceDefined implements Condition{

	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
	
		return context.getBeanFactory()
						.getBeansOfType(GreetingService.class)
						.isEmpty();
	}

}

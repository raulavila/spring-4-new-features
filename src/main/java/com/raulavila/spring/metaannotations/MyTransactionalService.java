package com.raulavila.spring.metaannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Service
@Transactional
public @interface MyTransactionalService {
	Propagation propagation() default Propagation.REQUIRED;
}

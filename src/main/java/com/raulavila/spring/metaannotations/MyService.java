package com.raulavila.spring.metaannotations;

import org.springframework.transaction.annotation.Propagation;

@MyTransactionalService(propagation=Propagation.REQUIRES_NEW)
public class MyService {
/****/
}

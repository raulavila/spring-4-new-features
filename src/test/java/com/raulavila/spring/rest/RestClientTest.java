package com.raulavila.spring.rest;

import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

//Run this tests after starting Embedded Jetty Server
public class RestClientTest {

	@Test
	public void testSyncRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:8080/items4", String.class);

		System.out.println("Received!:" + response.getBody());
	}

	@Test
	public void testAsyncRestTemplate1() {
		AsyncRestTemplate restTemplate = new AsyncRestTemplate();

		ListenableFuture<ResponseEntity<String>> futureEntity = restTemplate
				.getForEntity("http://localhost:8080/items4",
						String.class);

		futureEntity
				.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
					@Override
					public void onSuccess(ResponseEntity<String> result) {
						System.out.println("Received!: " + result.getBody());
					}

					@Override
					public void onFailure(Throwable t) {
						System.out.println("Fail!");
					}
				});

	    try {
	        // waits for the service to send the response
	        Thread.sleep(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	}

	@Test
	public void testAsyncRestTemplate2() {
		AsyncRestTemplate restTemplate = new AsyncRestTemplate();

		ListenableFuture<ResponseEntity<String>> futureEntity = restTemplate
				.getForEntity("http://localhost:8080/items4",
						String.class);
		ResponseEntity<String> result = null;
		try {
			result = futureEntity.get();
            System.out.println("Sent request!");

			System.out.println("Received: " + result.getBody());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}

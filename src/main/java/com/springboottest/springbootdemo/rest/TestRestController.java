package com.springboottest.springbootdemo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;


@RestController
@RequestMapping("/test")
public class TestRestController {
	
	private final Counter requestCount;
	
	TestRestController(CollectorRegistry collectorRegistry) {
		requestCount = Counter.build()
                .name("test_request_count")
                .help("Number of hello requests.")
                .register(collectorRegistry);
	}
	
	@GetMapping("/greet")
	public String greetCustomer() {
		System.out.println("/test/greet:  greet customer method called.");
		requestCount.inc();
		return "/test/greet:  Hello world";
	}
	
	@GetMapping("/greet/{username}")
	public String greetCustomerWithName(@PathVariable String username) {
		System.out.println("/test/greet:  greet customer with name method called.");
		requestCount.inc();
		return "/test/greet:  Hello " + username;
	}
}

package com.springboottest.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@GetMapping("/greet")
	public String greetCustomer() {
		System.out.println("greet customer method called.");
		return "Hello world";
	}
	
	@GetMapping("/greet/{username}")
	public String greetCustomerWithName(@PathVariable String username) {
		System.out.println("greet customer with name method called.");
		return "Hello " + username;
	}
}

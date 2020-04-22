package com.springboottest.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@GetMapping("/greet")
	public String greetCustomer() {
		return "Hello world";
	}
}

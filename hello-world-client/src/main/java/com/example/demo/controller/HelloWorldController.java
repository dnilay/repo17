package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private Environment environment;

	@Autowired
	public HelloWorldController(Environment environment) {
		super();
		this.environment = environment;
	}
	@GetMapping("/")
	public ResponseEntity<String> checkStatus()
	{
		return ResponseEntity.ok("app is running on port: "+environment.getProperty("local.server.port"));
	}
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello(@RequestParam("name") String name)
	{
		return ResponseEntity.ok("Hello "+name);
	}

}

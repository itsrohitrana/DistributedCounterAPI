package com.example.glaucusTest;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class RestResource {

	@Autowired
	CounterService counterService;
	
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return counter.addAndGet(1)+ name+" Hello";
	}
	
	
//	@RequestMapping(value = "/increment",
//	        method = RequestMethod.POST,
//	        produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
//	)
	@GetMapping("/increment")
	public void saveStock() throws InterruptedException {
		counterService.incrementCount();
		
	}
	
}
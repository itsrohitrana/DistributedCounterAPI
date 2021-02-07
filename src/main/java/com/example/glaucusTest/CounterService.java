package com.example.glaucusTest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {
	
	@Autowired
	NumberRepository numberRepository;
	
	@Transactional
	public void incrementCount() throws InterruptedException {
		
		System.out.println("Thread Strating :::::::"+Thread.currentThread()+"--at time--"+LocalDateTime.now());
		
		com.example.glaucusTest.dto.Number counterObj = numberRepository.findNumberForWrite(1l).get();
		counterObj.setCount(counterObj.getCount()+1);
		numberRepository.save(counterObj);
		System.out.println("Thread ending :::::::"+Thread.currentThread()+"--at time--"+LocalDateTime.now());
		
	}
	
}

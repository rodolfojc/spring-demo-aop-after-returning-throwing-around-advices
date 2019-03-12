package com.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//SIMULATE DELAY
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//RETURN A FORTUNE
		
		return "Expect heavy traffic this evening at 6 pm";
	}

	public String getFortune(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("Major accident! Highway is closed");
		}
		
		return getFortune();
	}
	
}

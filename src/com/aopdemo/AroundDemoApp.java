package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import com.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//READ CONFIG JAVA CLASS
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//GET THE BEAN FROM SPRING CONTAINER
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain program: AroundDemoApp");
		
		System.out.println("\nCalling method");
		
		String data = theFortuneService.getFortune();
		System.out.println(data);
		
		//CLOSE CONTEXT
		context.close();
		
	}

}

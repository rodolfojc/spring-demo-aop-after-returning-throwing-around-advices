package com.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import com.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//READ CONFIG JAVA CLASS
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//GET THE BEAN FROM SPRING CONTAINER
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain program: AroundDemoApp");
		
		myLogger.info("\nCalling method");
		
		String data = theFortuneService.getFortune();
		myLogger.info(data);
		
		//CLOSE CONTEXT
		context.close();
		
	}

}

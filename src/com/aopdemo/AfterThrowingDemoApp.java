package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//READ CONFIG JAVA CLASS
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//GET THE BEAN FROM SPRING CONTAINER
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//CALL METHOD FINDACCOUNT
		List<Account> theAccounts = null;
		
		try{
			//ADD A BOOLEAN TO SIMULATE EXCEPTIONS
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc) {
			System.out.println("\nMain program... Caught exception: "+exc);
		}
		
		//DISPLAY ACCOUNTS
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("-----");
		
		System.out.println(theAccounts);
		
		//CLOSE CONTEXT
		context.close();
		
	}

}

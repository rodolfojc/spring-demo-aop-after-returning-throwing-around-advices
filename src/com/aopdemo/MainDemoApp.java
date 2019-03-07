package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//READ CONFIG JAVA CLASS
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//GET THE BEAN FROM SPRING CONTAINER
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//GET THE BEAN MEMBERSHIP FROM SPRING CONTAINER
		MembershipDAO theMemberDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//CALL SETTER AND GETTERS
		theAccountDAO.setName("Rodolfo");
		theAccountDAO.setServiceCode("Gold");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//CALL METHODS
		Account myAccount = new Account();
		myAccount.setName("Carlos");
		myAccount.setLevel("Gold");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		theMemberDAO.addOtherAccount();
		theMemberDAO.goToSleep();
		
		//CLOSE CONTEXT
		context.close();
		
	}

}

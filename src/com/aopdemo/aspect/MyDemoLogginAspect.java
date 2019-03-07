package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	//ADD A NEW ADVICE FOR AFTERRETURNING 
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		//PRINT THE ADVICE
		String method = theJoinPoint.getSignature().toString();
		System.out.println("\n===> Executing @AfterReturning on method: "+method);
		
		//PRINT RESULT
		System.out.println("\n===> result is: "+result);
		
	}
	
	
	//@BEFORE
	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoSettersOrGetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("Executing @Before advice on addAccount()");
		
		//DISPLAY METHOD SIGNAURE
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		//DISPLAY METHOD ARGUMENTS
		
		//GET ARG
		Object[] args = theJoinPoint.getArgs();
		
		//DISPLEY ARG
		for (Object tempArgs : args) {
			System.out.println(tempArgs);
			
			if (tempArgs instanceof Account) {
				//DOWNCAST AND PRINT ACCOUNT 
				Account theAccount = (Account) tempArgs;
				System.out.println("Account name: "+theAccount.getName());
				System.out.println("Account level: "+theAccount.getLevel());
			}
			
			
		}
		
	}
	
	
}

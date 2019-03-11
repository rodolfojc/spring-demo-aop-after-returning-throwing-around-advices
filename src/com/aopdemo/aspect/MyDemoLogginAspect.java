package com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//PRINT THE ADVISE
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n===> Executing @aroundGetFortune on method: "+method);
		
		//GET BEGIN TIMESTAMP
		long begin = System.currentTimeMillis();
		
		//EXECUTE METHOD
		Object result = theProceedingJoinPoint.proceed();
		
		//GET END TIMESTAMP
		long end = System.currentTimeMillis();
		
		//COMPUTE DURATION AND DISPLAY
		long duration = end - begin;
		myLogger.info("\\n===> Duration: "+duration/1000.0+" seconds");
				
		return result;
	}
	
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvicee(JoinPoint theJoinPoint) {
		
		//PRINT THE ADVISE
		String method = theJoinPoint.getSignature().toString();
		myLogger.info("\n===> Executing @afterFinallyFindAccountAdvice on method: "+method);
		
	}
	
	
	
	
	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAcoountAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		//PRINT THE ADVISE
		String method = theJoinPoint.getSignature().toString();
		myLogger.info("\n===> Executing @afterThrowingFindAcoountAdvice on method: "+method);
		
		//PRINT LOG EXCEPTION
		myLogger.info("\n===> The exception is "+theExc);
		
	}
		
	//ADD A NEW ADVICE FOR AFTERRETURNING 
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		//PRINT THE ADVICE
		String method = theJoinPoint.getSignature().toString();
		myLogger.info("\n===> Executing @AfterReturning on method: "+method);
		
		//PRINT RESULT
		myLogger.info("\n===> result is: "+result);
		
		//POST-PROCESS THE DATA / MODIFY
		
		
		//CONVERT THE ACCOUNT NAMES TO UPPER CASE
		convertAccountNamesToUpperCase(result);
		
		//PRINT RESULT
		myLogger.info("\n===> result is: "+result);
		
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//LOOP ACCOUNTS 
		for (Account tempAccount : result) {
			
			//GET UPPERCASE VERSION OF NAME
			String theUpperName = tempAccount.getName().toUpperCase();
			
			//UPDATE NAME ON ACCOUNT
			tempAccount.setName(theUpperName);
		}
		
		//GET UPPERCASE VERSION OF NAME
		
		//UPDATE THE NAME ON ACCOUNT
		
	}


	//@BEFORE
	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoSettersOrGetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("Executing @Before advice on addAccount()");
		
		//DISPLAY METHOD SIGNAURE
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: "+methodSig);
		
		//DISPLAY METHOD ARGUMENTS
		
		//GET ARG
		Object[] args = theJoinPoint.getArgs();
		
		//DISPLEY ARG
		for (Object tempArgs : args) {
			myLogger.info(tempArgs.toString());
			
			if (tempArgs instanceof Account) {
				//DOWNCAST AND PRINT ACCOUNT 
				Account theAccount = (Account) tempArgs;
				myLogger.info("Account name: "+theAccount.getName());
				myLogger.info("Account level: "+theAccount.getLevel());
			}
			
			
		}
		
	}
	
	
}

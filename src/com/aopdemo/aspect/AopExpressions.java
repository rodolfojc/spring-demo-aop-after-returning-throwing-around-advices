package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

		//@POINCUT DECLARATION
		@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
		public void forDaoPackageDecl() {}
		
		//CREATE POINCUT FOR SETTER
		@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
		public void forSetter() {}
		
		//CREATE POINTCUT FOR GETTER
		@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
		public void forGetter() {}
		
		//CREATE POINTCUT EXCLUDE
		@Pointcut("forDaoPackageDecl() && !(forSetter() || forGetter())")
		public void forDaoPackageNoSettersOrGetters() {}
		
}

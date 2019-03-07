package com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass()+": DOING MY DB WORK, ACCOUNT");
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass()+": DOING WORK, ACCOUNT");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass()+": DOING getName, ACCOUNT");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": DOING setName, ACCOUNT");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": DOING getServiceCode, ACCOUNT");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": DOING setServiceCode, ACCOUNT");
		this.serviceCode = serviceCode;
	}
	
	
	
	
}

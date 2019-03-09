package com.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	//ADD NEW METHOD
	public List<Account> findAccounts(boolean tripWire){
		
		//SIMULATE AN EXCEPTION
		if (tripWire) {
			throw new RuntimeException("No pass for you Ok!!");
		}
		
		
		List<Account> myAccount = new ArrayList<>();
		
		//CREATE SOME ACCOUNTS
		Account tempAccOne = new Account("Lucy", "Gold");
		Account tempAccTwo = new Account("Juan", "Silver");
		Account tempAccThree = new Account("Cesar", "Gold");
		
		//ADD ACCOUNTS TO LIST#
		myAccount.add(tempAccOne);
		myAccount.add(tempAccTwo);
		myAccount.add(tempAccThree);
		
		return myAccount;
		
	}
		
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

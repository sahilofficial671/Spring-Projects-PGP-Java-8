package com.merrisonhotel;

import java.util.List;
import java.util.Scanner;

import com.merrisonhotel.daoImpl.CustomerDaoImpl;
import com.merrisonhotel.model.Customer;

public class Index {
	CustomerDaoImpl customerDaoImpl;
	
	public Index() {
		customerDaoImpl = new CustomerDaoImpl();
	}
	
	public void serveActions() {
		System.out.println("What do you want to do?");
		System.out.println("Select one of below option to perform action: \n");
		System.out.println("(1) Add Customer");
		System.out.println("(2) View Customers");
		System.out.println("(0) Exit");
	}
	
	public void action(Integer action) {
		try {		
			if(action != null && action == 1) {
				Customer customer = customerDaoImpl.getModelFromConsole();
				
		    	if(customer != null) {
		    		if(customerDaoImpl.add(customer)) {
		    			System.out.println("Customer successfully added.");
		    			System.out.println(customer);
		    		}
		    	}
			}

			
			if(action != null && action == 2) {
				List<Customer> customerList = customerDaoImpl.getCustomers();
				
				if(customerList.size() > 0) {
					for(Customer customer : customerList){
						System.out.println(customer);
					}
				}else {
					System.out.println("There are no customers yet.\n");
				}
			}
			
			if(action != null && action == 0) {
				System.out.println("Bye");
				System.exit(0);
				return ;
			}
			
			serveActions();
			action(getAction());
			
			return;	
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return ;
		}
	}
	@SuppressWarnings("resource")
	public Integer getAction() {
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.next());
	}
}

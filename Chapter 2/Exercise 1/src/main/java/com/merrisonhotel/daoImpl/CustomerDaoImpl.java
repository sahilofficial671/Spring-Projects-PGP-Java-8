package com.merrisonhotel.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.merrisonhotel.dao.CustomerDao;
import com.merrisonhotel.data.Data;
import com.merrisonhotel.model.Customer;

public class CustomerDaoImpl implements CustomerDao{
	Data data;
	private ApplicationContext ac;
	
	public CustomerDaoImpl() {
		data = Data.get();
		ac = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Override
	public Boolean add(Customer customer) {
		return data.getCustomerList().add(customer);
	}
	
	public List<Customer> getCustomers(){
		return data.getCustomerList();
	}

	@SuppressWarnings("resource")
	@Override
	public Customer getModelFromConsole() {
		try {
			Scanner sc = new Scanner(System.in);
			Customer customer = (Customer) ac.getBean("customer");
			
			System.out.println("Enter your first name:");
			customer.setId(data.getCustomerList().size() + 1);
			customer.setFirstName(sc.next());
			
			System.out.println("Enter your last name:");
			customer.setLastName(sc.next());
			
			System.out.println("Enter your email:");
			customer.setEmail(sc.next());
			
			return customer;
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return null;
		}
	}
}

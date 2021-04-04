package com.flipmart.daoImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flipmart.dao.CustomerDao;
import com.flipmart.data.Data;
import com.flipmart.model.Customer;

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
}

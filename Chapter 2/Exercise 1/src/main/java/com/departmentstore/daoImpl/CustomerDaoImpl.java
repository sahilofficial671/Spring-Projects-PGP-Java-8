package com.departmentstore.daoImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.departmentstore.dao.CustomerDao;
import com.departmentstore.data.Data;
import com.departmentstore.model.Customer;

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

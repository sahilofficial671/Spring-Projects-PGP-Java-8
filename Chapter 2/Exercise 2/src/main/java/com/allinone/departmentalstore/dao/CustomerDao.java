package com.allinone.departmentalstore.dao;

import java.util.List;

import com.allinone.departmentalstore.model.Customer;

public interface CustomerDao {
	public Boolean add(Customer customer);
	public List<Customer> getCustomers();
}

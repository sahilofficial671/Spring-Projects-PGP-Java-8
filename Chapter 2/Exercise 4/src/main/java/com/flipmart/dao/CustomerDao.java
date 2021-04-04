package com.flipmart.dao;

import java.util.List;

import com.flipmart.model.Customer;

public interface CustomerDao {
	public Boolean add(Customer customer);
	public List<Customer> getCustomers();
}

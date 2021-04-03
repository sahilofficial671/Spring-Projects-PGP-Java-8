package com.merrisonhotel.dao;

import java.util.List;

import com.merrisonhotel.model.Customer;

public interface CustomerDao {
	public Boolean add(Customer customer);
	public List<Customer> getCustomers();
	public Customer getModelFromConsole();
}

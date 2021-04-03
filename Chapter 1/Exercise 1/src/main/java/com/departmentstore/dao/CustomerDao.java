package com.departmentstore.dao;

import java.util.List;

import com.departmentstore.model.Customer;

public interface CustomerDao {
	public Boolean add(Customer customer);
	public List<Customer> getCustomers();
}

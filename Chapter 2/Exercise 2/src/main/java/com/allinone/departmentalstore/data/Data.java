package com.allinone.departmentalstore.data;

import java.util.ArrayList;
import java.util.List;

import com.allinone.departmentalstore.model.Customer;
import com.allinone.departmentalstore.model.Order;
import com.allinone.departmentalstore.model.Product;

public class Data {
	private static Data data = null;
	List<Product> productList;
	List<Customer> customerList;
	List<Order> orderList;
	
	Data() {
		productList = new ArrayList<Product>();
		customerList = new ArrayList<Customer>();
		orderList = new ArrayList<Order>();
	}
	
	public static Data get() {
		if(data != null) return data;
		data = new Data();
		return data;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}
}

package com.flipmart.data;

import java.util.ArrayList;
import java.util.List;

import com.flipmart.model.Customer;
import com.flipmart.model.Order;
import com.flipmart.model.Item;

public class Data {
	private static Data data = null;
	List<Item> itemList;
	List<Customer> customerList;
	List<Order> orderList;
	
	Data() {
		itemList = new ArrayList<Item>();
		customerList = new ArrayList<Customer>();
		orderList = new ArrayList<Order>();
	}
	
	public static Data get() {
		if(data != null) return data;
		data = new Data();
		return data;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}
}

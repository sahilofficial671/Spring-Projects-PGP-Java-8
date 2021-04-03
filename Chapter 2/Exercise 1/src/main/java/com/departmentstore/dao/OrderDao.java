package com.departmentstore.dao;

import java.util.List;

import com.departmentstore.model.Order;

public interface OrderDao {
	public Order getModelFromConsole();
	public Boolean add(Order order);
	public List<Order> getOrders();
	public void display(Order order);
}

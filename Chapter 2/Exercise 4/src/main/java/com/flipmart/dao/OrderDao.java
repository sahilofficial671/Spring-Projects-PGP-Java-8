package com.flipmart.dao;

import java.util.List;

import com.flipmart.model.Order;

public interface OrderDao {
	public Order getModelFromConsole();
	public Boolean add(Order order);
	public List<Order> getOrders();
	public void display(Order order);
}

package com.flipmart;

import java.util.List;
import java.util.Scanner;

import com.flipmart.daoImpl.CustomerDaoImpl;
import com.flipmart.daoImpl.OrderDaoImpl;
import com.flipmart.daoImpl.ItemDaoImpl;
import com.flipmart.model.Customer;
import com.flipmart.model.Order;
import com.flipmart.model.Item;

public class Index {
	ItemDaoImpl itemDaoImpl;
	OrderDaoImpl orderDaoImpl;
	CustomerDaoImpl customerDaoImpl;
	
	public Index() {
		itemDaoImpl = new ItemDaoImpl();
		orderDaoImpl = new OrderDaoImpl();
		customerDaoImpl = new CustomerDaoImpl();
	}
	
	public void serveActions() {
		System.out.println("What do you want to do?");
		System.out.println("Select one of below option to perform action: \n");
		System.out.println("(1) Enter item");
		System.out.println("(2) View items");
		System.out.println("(3) Order item");
		System.out.println("(4) View Orders");
		System.out.println("(5) View Customers");
		System.out.println("(0) Exit");
	}
	
	public void action(Integer action) {
		try {		
			if(action != null && action == 1) {
				Item item =   itemDaoImpl.getModelFromConsole();
		    	if(item != null) {
		    		if(itemDaoImpl.add(item)) {
		    			System.out.println("Item Added.");
		    			System.out.println(itemDaoImpl.getItems());
		    		}
		    	}
		    	
    			serveActions();
    			action(getAction());
			}
			
			if(action != null && action == 2) {
				List<Item> itemList = itemDaoImpl.getItems();
				
				if(itemList.size() > 0) {
					for(Item item : itemList){
						System.out.println(item);
					}
				}else {
					System.out.println("There are no items.\n");
				}
				
				serveActions();
    			action(getAction());
			}
			
			if(action != null && action == 3) {
				Order order =   orderDaoImpl.getModelFromConsole();
		    	if(order != null) {
		    		if(orderDaoImpl.add(order)) {
		    			System.out.println("Order successful.");
		    			orderDaoImpl.display(order);
		    		}
		    	}
			}
			
			if(action != null && action == 4) {
				List<Order> orderList = orderDaoImpl.getOrders();
				
				if(orderList.size() > 0) {
					for(Order order : orderList){
						System.out.println(order);
					}
				}else {
					System.out.println("There are no orders.\n");
				}
			}
			
			if(action != null && action == 5) {
				List<Customer> customerList = customerDaoImpl.getCustomers();
				
				if(customerList.size() > 0) {
					for(Customer customer : customerList){
						System.out.println(customer);
					}
				}else {
					System.out.println("There are no customers yet.\n");
				}
			}
			
			if(action != null && action == 0) {
				System.out.println("Bye");
				System.exit(0);
				return ;
			}
			
			serveActions();
			action(getAction());
			
			return;	
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return ;
		}
	}
	@SuppressWarnings("resource")
	public Integer getAction() {
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.next());
	}
}

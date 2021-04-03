package com.departmentstore;

import java.util.List;
import java.util.Scanner;

import com.departmentstore.daoImpl.CustomerDaoImpl;
import com.departmentstore.daoImpl.OrderDaoImpl;
import com.departmentstore.daoImpl.ProductDaoImpl;
import com.departmentstore.model.Customer;
import com.departmentstore.model.Order;
import com.departmentstore.model.Product;

public class Index {
	ProductDaoImpl productDaoImpl;
	OrderDaoImpl orderDaoImpl;
	CustomerDaoImpl customerDaoImpl;
	
	public Index() {
		productDaoImpl = new ProductDaoImpl();
		orderDaoImpl = new OrderDaoImpl();
		customerDaoImpl = new CustomerDaoImpl();
	}
	
	public void serveActions() {
		System.out.println("What do you want to do?");
		System.out.println("Select one of below option to perform action: \n");
		System.out.println("(1) Enter Product");
		System.out.println("(2) View Products");
		System.out.println("(3) Order Product");
		System.out.println("(4) View Orders");
		System.out.println("(5) View Customers");
		System.out.println("(0) Exit");
	}
	
	public void action(Integer action) {
		try {		
			if(action != null && action == 1) {
				Product product =   productDaoImpl.getModelFromConsole();
		    	if(product != null) {
		    		if(productDaoImpl.add(product)) {
		    			System.out.println("Product Added.");
		    			System.out.println(productDaoImpl.getProducts());
		    		}
		    	}
		    	
    			serveActions();
    			action(getAction());
			}
			
			if(action != null && action == 2) {
				List<Product> productList = productDaoImpl.getProducts();
				
				if(productList.size() > 0) {
					for(Product product : productList){
						System.out.println(product);
					}
				}else {
					System.out.println("There are no products.\n");
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
			String message = "Error From: "+ App.class.getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
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

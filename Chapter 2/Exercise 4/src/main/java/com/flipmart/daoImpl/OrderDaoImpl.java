package com.flipmart.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flipmart.dao.OrderDao;
import com.flipmart.data.Data;
import com.flipmart.model.Customer;
import com.flipmart.model.Order;
import com.flipmart.model.Item;

public class OrderDaoImpl implements OrderDao {
	Data data;
	private ApplicationContext ac;
	
	public OrderDaoImpl() {
		data = Data.get();
		ac = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Override
	public Boolean add(Order order) {
		try {
			return data.getOrderList().add(order);
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return false;
		}
	}

	@SuppressWarnings("resource")
	@Override
	public Order getModelFromConsole() {
		try {
			if(data.getItemList().size() <= 0) {
				System.out.println("There are no products. Please add product first.\n");
				return null;
			}
			
			Customer customer = (Customer) ac.getBean("customer");
			Order order = (Order) ac.getBean("order");
			ItemDaoImpl itemDaoImpl = new ItemDaoImpl();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Select which product to order: \n");
			
			for(Item item : data.getItemList()) {
				System.out.println("("+item.getId()+") "+item.getName()+" [Qty Available: "+item.getQuantity()+"]");
			}
			
			order.setId(data.getOrderList().size() + 1);
			order.setItem(itemDaoImpl.getItem(sc.nextInt()));
			
			System.out.println("Please provide some order details:\n");
			System.out.println("Enter your first name:");
			customer.setId(data.getCustomerList().size() + 1);
			customer.setFirstName(sc.next());
			
			System.out.println("Enter your last name:");
			customer.setLastName(sc.next());
			
			System.out.println("Enter your email:");
			customer.setEmail(sc.next());
			
			order.setCustomer(customer);
			data.getCustomerList().add(customer);
			
			System.out.println("Enter your order quantity:");
			order.setQuantity(sc.nextInt());
			
			if(order.getQuantity() > order.getItem().getQuantity()) {
				System.out.println("Order quantity not available.");
				return null;
			}
			
			return order;
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return null;
		}
	}

	@Override
	public List<Order> getOrders() {
		return data.getOrderList();
	}

	@Override
	public void display(Order order) {
		System.out.println("Order Details: \n");
		System.out.println("Order ID: "+order.getId());
		System.out.println("Ordered Product: "+order.getItem().getName()+ "[Quantity: "+order.getQuantity()+"]");
		System.out.println("Order by: "+order.getCustomer().getName()+" [ID: "+order.getCustomer().getId()+"]");
	}

}

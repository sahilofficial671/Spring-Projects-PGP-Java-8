package com.departmentstore.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.departmentstore.dao.OrderDao;
import com.departmentstore.data.Data;
import com.departmentstore.model.Customer;
import com.departmentstore.model.Order;
import com.departmentstore.model.Product;

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
			if(data.getProductList().size() <= 0) {
				System.out.println("There are no products. Please add product first.\n");
				return null;
			}
			
			Customer customer = (Customer) ac.getBean("customer");
			Order order = (Order) ac.getBean("order");
			ProductDaoImpl productDaoImpl = new ProductDaoImpl();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Select which product to order: \n");
			
			for(Product product : data.getProductList()) {
				System.out.println("("+product.getId()+") "+product.getName()+" [Qty Available: "+product.getQuantity()+"]");
			}
			
			order.setId(data.getOrderList().size() + 1);
			order.setProduct(productDaoImpl.getProduct(sc.nextInt()));
			
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
			
			if(order.getQuantity() > order.getProduct().getQuantity()) {
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
		System.out.println("Ordered Product: "+order.getProduct().getName()+ "[Quantity: "+order.getQuantity()+"]");
		System.out.println("Order by: "+order.getCustomer().getName()+" [ID: "+order.getCustomer().getId()+"]");
	}

}

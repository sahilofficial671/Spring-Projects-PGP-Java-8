package com.wiley.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wiley.dao.OrderDao;
import com.wiley.data.Data;
import com.wiley.model.Author;
import com.wiley.model.Order;
import com.wiley.model.Book;

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
			if(data.getBookList().size() <= 0) {
				System.out.println("There are no books. Please add product first.\n");
				return null;
			}
			
			Author author = (Author) ac.getBean("author");
			Order order = (Order) ac.getBean("order");
			BookDaoImpl bookDaoImpl = new BookDaoImpl();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Select which product to order: \n");
			
			for(Book product : data.getBookList()) {
				System.out.println("("+product.getId()+") "+product.getName()+" [Qty Available: "+product.getQuantity()+"]");
			}
			
			order.setId(data.getOrderList().size() + 1);
			order.setBook(bookDaoImpl.getBook(sc.nextInt()));
			
			System.out.println("Please provide some order details:\n");
			System.out.println("Enter your first name:");
			author.setId(data.getAuthorList().size() + 1);
			author.setFirstName(sc.next());
			
			System.out.println("Enter your last name:");
			author.setLastName(sc.next());
			
			System.out.println("Enter your email:");
			author.setEmail(sc.next());
			
			order.setAuthor(author);
			data.getAuthorList().add(author);
			
			System.out.println("Enter your order quantity:");
			order.setQuantity(sc.nextInt());
			
			if(order.getQuantity() > order.getBook().getQuantity()) {
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
		System.out.println("Ordered Product: "+order.getBook().getName()+ "[Quantity: "+order.getQuantity()+"]");
		System.out.println("Order by: "+order.getAuthor().getName()+" [ID: "+order.getAuthor().getId()+"]");
	}

}

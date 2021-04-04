package com.wiley;

import java.util.List;
import java.util.Scanner;

import com.wiley.daoImpl.AuthorDaoImpl;
import com.wiley.daoImpl.OrderDaoImpl;
import com.wiley.daoImpl.BookDaoImpl;
import com.wiley.model.Author;
import com.wiley.model.Order;
import com.wiley.model.Book;

public class Index {
	BookDaoImpl bookDaoImpl;
	OrderDaoImpl orderDaoImpl;
	AuthorDaoImpl authorDaoImpl;
	
	public Index() {
		bookDaoImpl = new BookDaoImpl();
		orderDaoImpl = new OrderDaoImpl();
		authorDaoImpl = new AuthorDaoImpl();
	}
	
	public void serveActions() {
		System.out.println("What do you want to do?");
		System.out.println("Select one of below option to perform action: \n");
		System.out.println("(1) Enter Books");
		System.out.println("(2) View Books");
		System.out.println("(3) Order Book");
		System.out.println("(4) View Orders");
		System.out.println("(5) View Authors");
		System.out.println("(0) Exit");
	}
	
	public void action(Integer action) {
		try {		
			if(action != null && action == 1) {
				Book book =   bookDaoImpl.getModelFromConsole();
		    	if(book != null) {
		    		if(bookDaoImpl.add(book)) {
		    			System.out.println("book Added.");
		    			System.out.println(bookDaoImpl.getBooks());
		    		}
		    	}
		    	
    			serveActions();
    			action(getAction());
			}
			
			if(action != null && action == 2) {
				List<Book> bookList = bookDaoImpl.getBooks();
				
				if(bookList.size() > 0) {
					for(Book book : bookList){
						System.out.println(book);
					}
				}else {
					System.out.println("There are no books.\n");
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
				List<Author> authorList = authorDaoImpl.getAuthors();
				
				if(authorList.size() > 0) {
					for(Author author : authorList){
						System.out.println(author);
					}
				}else {
					System.out.println("There are no authors yet.\n");
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

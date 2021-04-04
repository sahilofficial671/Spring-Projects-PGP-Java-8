package com.wiley.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wiley.dao.BookDao;
import com.wiley.data.Data;
import com.wiley.model.Book;

public class BookDaoImpl implements BookDao {
	Data data;
	private ApplicationContext ac;
	
	public BookDaoImpl() {
		data = Data.get();
		ac = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Override
	public Boolean add(Book book) {
		try {
			return data.getBookList().add(book);
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return false;
		}
		
	}

	@SuppressWarnings("resource")
	@Override
	public Book getModelFromConsole() {
		try {
			Scanner sc = new Scanner(System.in);
			Book book = (Book) ac.getBean("book");
		
			book.setId(data.getBookList().size() + 1);
			
			System.out.println("Enter Book Name: ");
			book.setName(sc.next());
			
			System.out.println("Enter Book Quantity: ");
			book.setQuantity(sc.nextInt());
			
			System.out.println("Enter Book Price: ");
			book.setPrice(sc.nextInt());
			
			return book;
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return null;
		}
	}

	@Override
	public List<Book> getBooks() {
		return data.getBookList();
	}

	@Override
	public Book getBook(Integer id) {
		for(Book book : getBooks()) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}

}

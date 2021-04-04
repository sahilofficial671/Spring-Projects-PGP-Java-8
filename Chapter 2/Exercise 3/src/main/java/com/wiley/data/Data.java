package com.wiley.data;

import java.util.ArrayList;
import java.util.List;

import com.wiley.model.Author;
import com.wiley.model.Order;
import com.wiley.model.Book;

public class Data {
	private static Data data = null;
	List<Book> bookList;
	List<Author> authorList;
	List<Order> orderList;
	
	Data() {
		bookList = new ArrayList<Book>();
		authorList = new ArrayList<Author>();
		orderList = new ArrayList<Order>();
	}
	
	public static Data get() {
		if(data != null) return data;
		data = new Data();
		return data;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}
}

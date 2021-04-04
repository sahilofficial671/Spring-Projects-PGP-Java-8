package com.wiley.dao;

import java.util.List;

import com.wiley.model.Book;

public interface BookDao {
	public Book getModelFromConsole();
	public Boolean add(Book book);
	public List<Book> getBooks();
	public Book getBook(Integer id);
}

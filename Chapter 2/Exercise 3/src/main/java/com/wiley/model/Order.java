package com.wiley.model;

public class Order {
	private Integer id;
	private Book book;
	private Author author;
	private Integer quantity;
	public Order() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author customer) {
		this.author = customer;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", book=" + book + ", author=" + author + ", quantity=" + quantity + "]";
	}
	
}

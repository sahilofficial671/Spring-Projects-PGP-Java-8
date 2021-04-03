package com.allinone.departmentalstore.model;

import java.sql.Timestamp;

public class Order {
	private Integer id;
	private Product product;
	private Customer customer;
	private Integer quantity;
	public Order() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", customer=" + customer + ", quantity=" + quantity + "]";
	}
	
}

package com.flipmart.model;

public class Order {
	private Integer id;
	private Item item;
	private Customer customer;
	private Integer quantity;
	public Order() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
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
		return "Order [id=" + id + ", item=" + item + ", customer=" + customer + ", quantity=" + quantity + "]";
	}
	
}

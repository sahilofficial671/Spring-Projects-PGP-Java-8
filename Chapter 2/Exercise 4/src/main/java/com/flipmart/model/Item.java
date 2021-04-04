package com.flipmart.model;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer quantity;
	private Integer price;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
}

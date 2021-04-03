package com.merrisonhotel.model;

public class Room {
	private Integer id;
	private Integer number, floor;
	private Double price;
	private Customer customer;
	public Room() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", floor=" + floor + ", price=" + price + ", customer="
				+ customer + "]";
	}
}

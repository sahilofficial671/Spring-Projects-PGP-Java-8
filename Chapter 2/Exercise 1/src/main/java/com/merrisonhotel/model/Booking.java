package com.merrisonhotel.model;

import java.sql.Timestamp;

public class Booking {
	private Integer id;
	private Customer customer;
	private Room room;
	private Timestamp bookedAt;
	public Booking() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Timestamp getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(Timestamp bookedAt) {
		this.bookedAt = bookedAt;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", customer=" + customer + ", room=" + room + ", bookedAt=" + bookedAt + "]";
	}

}

package com.nycab.model;

import java.sql.Timestamp;

public class Booking {
	private Integer id;
	private User user;
	private Cab room;
	private Timestamp bookedAt;
	public Booking() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Cab getRoom() {
		return room;
	}
	public void setRoom(Cab room) {
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
		return "Booking [id=" + id + ", user=" + user + ", room=" + room + ", bookedAt=" + bookedAt + "]";
	}

}

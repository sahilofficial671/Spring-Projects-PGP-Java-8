package com.nycab.data;

import java.util.ArrayList;
import java.util.List;

import com.nycab.model.Booking;
import com.nycab.model.User;
import com.nycab.model.Cab;
public class Data {
	private static Data data = null;
	private List<User> userList;
	private List<Cab> cabList;
	private List<Booking> bookingList;
	Data() {
		userList = new ArrayList<User>();
		cabList = new ArrayList<Cab>();
		bookingList = new ArrayList<Booking>();
	}
	
	public static Data get() {
		if(data != null) return data;
		data = new Data();
		return data;
	}
	public List<User> getUserList() {
		return userList;
	}

	public List<Cab> getCabList() {
		return cabList;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}
}

package com.merrisonhotel.data;

import java.util.ArrayList;
import java.util.List;

import com.merrisonhotel.model.Booking;
import com.merrisonhotel.model.Customer;
import com.merrisonhotel.model.Room;
public class Data {
	private static Data data = null;
	private List<Customer> customerList;
	private List<Room> roomList;
	private List<Booking> bookingList;
	Data() {
		customerList = new ArrayList<Customer>();
		roomList = new ArrayList<Room>();
		bookingList = new ArrayList<Booking>();
	}
	
	public static Data get() {
		if(data != null) return data;
		data = new Data();
		return data;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}
}

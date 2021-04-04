package com.nycab.model;

public class Cab {
	private Integer id;
	private String model, owner;
	private Double rate;
	private User bookedBy;
	public Cab() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public User getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}
	@Override
	public String toString() {
		return "Cab [id=" + id + ", model=" + model + ", owner=" + owner + ", rate=" + rate + ", bookedBy=" + bookedBy
				+ "]";
	}

}

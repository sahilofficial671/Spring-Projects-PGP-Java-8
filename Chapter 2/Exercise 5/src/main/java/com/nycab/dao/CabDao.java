package com.nycab.dao;

import java.util.List;

import com.nycab.model.Cab;

public interface CabDao {
	public Boolean add(Cab cab);
	public List<Cab> getCabs();
}

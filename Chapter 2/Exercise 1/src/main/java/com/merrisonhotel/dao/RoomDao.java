package com.merrisonhotel.dao;

import java.util.List;

import com.merrisonhotel.model.Room;

public interface RoomDao {
	public Boolean add(Room room);
	public List<Room> getRooms();
}

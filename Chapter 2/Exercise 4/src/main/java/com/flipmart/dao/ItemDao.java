package com.flipmart.dao;

import java.util.List;

import com.flipmart.model.Item;

public interface ItemDao {
	public Item getModelFromConsole();
	public Boolean add(Item item);
	public List<Item> getItems();
	public Item getItem(Integer id);
}

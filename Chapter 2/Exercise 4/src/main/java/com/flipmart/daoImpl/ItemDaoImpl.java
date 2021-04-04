package com.flipmart.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flipmart.dao.ItemDao;
import com.flipmart.data.Data;
import com.flipmart.model.Item;

public class ItemDaoImpl implements ItemDao {
	Data data;
	private ApplicationContext ac;
	
	public ItemDaoImpl() {
		data = Data.get();
		ac = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Override
	public Boolean add(Item item) {
		try {
			return data.getItemList().add(item);
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return false;
		}
		
	}

	@SuppressWarnings("resource")
	@Override
	public Item getModelFromConsole() {
		try {
			Scanner sc = new Scanner(System.in);
			Item item = (Item) ac.getBean("item");
		
			item.setId(data.getItemList().size() + 1);
			
			System.out.println("Enter Product Name: ");
			item.setName(sc.next());
			
			System.out.println("Enter Product Quantity: ");
			item.setQuantity(sc.nextInt());
			
			System.out.println("Enter Product Price: ");
			item.setPrice(sc.nextInt());
			
			return item;
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return null;
		}
	}

	@Override
	public List<Item> getItems() {
		return data.getItemList();
	}

	@Override
	public Item getItem(Integer id) {
		for(Item item : getItems()) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}

}

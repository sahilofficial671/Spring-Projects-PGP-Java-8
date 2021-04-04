package com.nycab.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nycab.dao.UserDao;
import com.nycab.data.Data;
import com.nycab.model.User;

public class UserDaoImpl implements UserDao{
	Data data;
	private ApplicationContext ac;
	
	public UserDaoImpl() {
		data = Data.get();
		ac = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Override
	public Boolean add(User user) {
		return data.getUserList().add(user);
	}
	
	public List<User> getUsers(){
		return data.getUserList();
	}

	@SuppressWarnings("resource")
	@Override
	public User getModelFromConsole() {
		try {
			Scanner sc = new Scanner(System.in);
			User user = (User) ac.getBean("user");
			
			System.out.println("Enter your first name:");
			user.setId(data.getUserList().size() + 1);
			user.setFirstName(sc.next());
			
			System.out.println("Enter your last name:");
			user.setLastName(sc.next());
			
			System.out.println("Enter your email:");
			user.setEmail(sc.next());
			
			return user;
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return null;
		}
	}
}

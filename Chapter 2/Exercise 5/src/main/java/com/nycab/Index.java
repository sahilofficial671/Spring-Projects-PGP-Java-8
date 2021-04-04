package com.nycab;

import java.util.List;
import java.util.Scanner;

import com.nycab.daoImpl.UserDaoImpl;
import com.nycab.model.User;

public class Index {
	UserDaoImpl userDaoImpl;
	
	public Index() {
		userDaoImpl = new UserDaoImpl();
	}
	
	public void serveActions() {
		System.out.println("What do you want to do?");
		System.out.println("Select one of below option to perform action: \n");
		System.out.println("(1) Add User");
		System.out.println("(2) View Users");
		System.out.println("(0) Exit");
	}
	
	public void action(Integer action) {
		try {		
			if(action != null && action == 1) {
				User user = userDaoImpl.getModelFromConsole();
				
		    	if(user != null) {
		    		if(userDaoImpl.add(user)) {
		    			System.out.println("User successfully added.");
		    			System.out.println(user);
		    		}
		    	}
			}

			
			if(action != null && action == 2) {
				List<User> userList = userDaoImpl.getUsers();
				
				if(userList.size() > 0) {
					for(User user : userList){
						System.out.println(user);
					}
				}else {
					System.out.println("There are no users yet.\n");
				}
			}
			
			if(action != null && action == 0) {
				System.out.println("Bye");
				System.exit(0);
				return ;
			}
			
			serveActions();
			action(getAction());
			
			return;	
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return ;
		}
	}
	@SuppressWarnings("resource")
	public Integer getAction() {
		Scanner sc = new Scanner(System.in);
		return Integer.parseInt(sc.next());
	}
}

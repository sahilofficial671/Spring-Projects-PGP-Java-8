package com.allinone.departmentalstore.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.allinone.departmentalstore.dao.ProductDao;
import com.allinone.departmentalstore.data.Data;
import com.allinone.departmentalstore.model.Product;

public class ProductDaoImpl implements ProductDao {
	Data data;
	private ApplicationContext ac;
	
	public ProductDaoImpl() {
		data = Data.get();
		ac = new ClassPathXmlApplicationContext("spring-config.xml");
	}

	@Override
	public Boolean add(Product product) {
		try {
			return data.getProductList().add(product);
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return false;
		}
		
	}

	@SuppressWarnings("resource")
	@Override
	public Product getModelFromConsole() {
		try {
			Scanner sc = new Scanner(System.in);
			Product product = (Product) ac.getBean("product");
		
			product.setId(data.getProductList().size() + 1);
			
			System.out.println("Enter Product Name: ");
			product.setName(sc.next());
			
			System.out.println("Enter Product Quantity: ");
			product.setQuantity(sc.nextInt());
			
			System.out.println("Enter Product Price: ");
			product.setPrice(sc.nextInt());
			
			return product;
		}catch(Exception e) {
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return null;
		}
	}

	@Override
	public List<Product> getProducts() {
		return data.getProductList();
	}

	@Override
	public Product getProduct(Integer id) {
		for(Product product : getProducts()) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

}

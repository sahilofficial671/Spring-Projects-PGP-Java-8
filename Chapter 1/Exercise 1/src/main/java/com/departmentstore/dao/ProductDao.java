package com.departmentstore.dao;

import java.util.List;

import com.departmentstore.model.Product;

public interface ProductDao {
	public Product getModelFromConsole();
	public Boolean add(Product product);
	public List<Product> getProducts();
	public Product getProduct(Integer id);
}

package com.springproj.shoppingbackend.dao;

import java.util.List;

import com.springproj.shoppingbackend.dto.Product;


public interface ProductDAO {
	
	boolean update(Product product);
	Product get(int productID);
	boolean delete(Product product);
	List<Product> list();
	boolean add(Product product);
	
	List<Product> getAllActiveProducts();
	List<Product> getAllActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProduct(int count);
	
	
}

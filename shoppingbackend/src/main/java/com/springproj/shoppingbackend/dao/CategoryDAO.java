package com.springproj.shoppingbackend.dao;

import java.util.List;

import com.springproj.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	List<Category> list();
	
	Category get(int id);
}

package com.springproj.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springproj.shoppingbackend.dao.CategoryDAO;
import com.springproj.shoppingbackend.dto.Category;


@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	
	private static List<Category> categories = new ArrayList<>();
	static
	{
		Category category = new Category();
		
		category.setId(1);
		category.setName("tele");
		category.setDescription("television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		Category category2 = new Category();
		
		category2.setId(2);
		category2.setName("mob");
		category2.setDescription("mobile");
		category2.setImageURL("CAT_2.png");
		
		categories.add(category2);
		
		Category category3 = new Category();
		
		category3.setId(3);
		category3.setName("lap");
		category3.setDescription("laptop");
		category3.setImageURL("CAT_3.png");
		
		categories.add(category3);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
	
		for (Category category : categories)
		{
			if(category.getId()==id)
				return category;
		}
		return null;
	}

}

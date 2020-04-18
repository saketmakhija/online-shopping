package com.springproj.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springproj.shoppingbackend.dao.CategoryDAO;
import com.springproj.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.springproj.shoppingbackend");
		context.refresh();
		categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
	}
	/*
	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("tele");
		category.setDescription("television");
		category.setImageURL("CAT_1.png");
		assertEquals("successfully added category inside a table", true, categoryDAO.add(category));
	}*/
	
	/*
	 * @Test
	public void testGetCategory()
	{
		category=categoryDAO.get(1);
		
		
		assertEquals("getting tele from db", "tele", category.getName());
	}*/
	
	/*
	@Test
	public void testUpdateCategory()
	{
		category=categoryDAO.get(1);
		category.setName("TV");
		
		assertEquals("successfully changing value ", true, categoryDAO.update(category));
	
	}*/
	
	/*
	@Test
	public void testDeleteCategory()
	{
		category=categoryDAO.get(1);
		assertEquals("successfully dectivating category ", true, categoryDAO.delete(category));
	}
	*/
	
	/*
	@Test
	public void testListCategory()
	{
		assertEquals("successfully fetched category list ", 1, categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory()
	{
		category = new Category();
		category.setName("Television");
		category.setDescription("this is a television category");
		category.setImageURL("CAT_1.png");
		assertEquals("successfully added category inside a table", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is laptop category");
		category.setImageURL("CAT_2.png");
		assertEquals("successfully added category inside a table", true, categoryDAO.add(category));
		
		category=categoryDAO.get(1);
		category.setName("TV");
		
		assertEquals("successfully changing value ", true, categoryDAO.update(category));
		
		assertEquals("successfully dectivating category ", true, categoryDAO.delete(category));
		
		assertEquals("successfully fetched category list ", 1, categoryDAO.list().size());
		
		
	}
}

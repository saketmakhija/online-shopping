package com.springproj.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springproj.shoppingbackend.dao.ProductDAO;
import com.springproj.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.springproj.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	@Test
	public void testCRUDProduct()
	{
		product = new Product();
		
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		//product.setQuantity(2);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("something went wrong in adding product",true, productDAO.add(product));
		
		product = productDAO.get(2);
		product.setBrand("Samsung");
		
		assertEquals("something went wrong in updating product",true, productDAO.update(product));
		
		assertEquals("something went wrong in deleting product",true, productDAO.delete(product));
		
		assertEquals("something went wrong in getting all product ", 6, productDAO.list().size());
		
		
		
		assertEquals("something went wrong in getting active  product ", 5, productDAO.getAllActiveProducts().size());
		
		assertEquals("something went wrong in getting active  product of category ", 3, productDAO.getAllActiveProductsByCategory(3).size());
		
		assertEquals("something went wrong in getting active  product latest", 3, productDAO.getLatestActiveProduct(3).size());
	}
}

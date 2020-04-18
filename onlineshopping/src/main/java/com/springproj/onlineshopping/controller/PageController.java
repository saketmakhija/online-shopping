package com.springproj.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproj.onlineshopping.exception.ProductNotFoundException;
import com.springproj.shoppingbackend.dao.CategoryDAO;
import com.springproj.shoppingbackend.dao.ProductDAO;
import com.springproj.shoppingbackend.dto.Category;
import com.springproj.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		LOGGER.info("inside index for info");
		LOGGER.debug("inside index for debug");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	//methods to show products on the basis of category
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		Category category = null;
		
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("category",category);
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if (product== null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	/*@RequestMapping(value= "/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		if(greeting!=null)
		{
			
			mv.addObject("greeting",greeting);
		}
		else
		{
			mv.addObject("greeting","Hi There");
		}
			
		return mv;
	}*/
	
	@RequestMapping(value= "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		if(greeting!=null)
		{
			
			mv.addObject("greeting",greeting);
		}
		else
		{
			mv.addObject("greeting","Hi There");
		}
			
		return mv;
	}
}

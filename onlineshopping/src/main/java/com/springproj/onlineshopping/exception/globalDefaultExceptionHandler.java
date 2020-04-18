package com.springproj.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class globalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "the page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is not available");
		mv.addObject("title","404 error page");
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "The product you are looking for is not available right now");
		mv.addObject("title","Product unavailable");
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your Administration!");
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("title","Error");
		return mv;
		
	}
}

package com.springproj.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproj.shoppingbackend.dao.ProductDAO;
import com.springproj.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean update(Product product) {
		
		try {
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Product get(int productId) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return false;
	}

	@Override
	public List<Product> list() {
		//String getActiveProduct = "FROM Product WHERE active=:active";
		
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			//add the category to the database
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getAllActiveProducts() {
		
		String getActiveProducts = "FROM Product WHERE active=:active";
		return sessionFactory.getCurrentSession().createQuery(getActiveProducts, Product.class).setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> getAllActiveProductsByCategory(int categoryId) {
		
		String getActiveProductByCategory = "FROM Product WHERE active=:active AND categoryId=:categoryId";
		
		return sessionFactory.getCurrentSession().createQuery(getActiveProductByCategory, Product.class)
				.setParameter("active", true)
					.setParameter("categoryId", categoryId)
						.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		
		String getLatestProduct = "FROM Product WHERE active=:active ORDER BY id";
		
		return sessionFactory.getCurrentSession().createQuery(getLatestProduct, Product.class)
				.setParameter("active", true)
					.setFirstResult(0)
						.setMaxResults(3)
							.getResultList();
	}

}

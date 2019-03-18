package com.cts.grizzly_store.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly_store.bean.Category;
import com.cts.grizzly_store.bean.Product;



@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO {
	@Autowired

	 private SessionFactory sessionFacotry;

	@Transactional
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		Session session =null;
		String query="from Product";
		org.hibernate.query.Query<Product> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Product> list=query2.getResultList();
		System.out.println(list);
		return list;
	}

	public List<Product> getProductById(String uderName, Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Transactional
	public String insertProduct(Product product) {
		// TODO Auto-generated method stub
		Session session = null;
		// TODO Auto-generated method stub
	
			session = sessionFacotry.getCurrentSession();

		session.save(product);
		return "Success";

		}
		
		
	public List<Product> getAllProductbylowtohigh(String order) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if(order.equals("LowToHigh")){
		query="from Product order by productId asc";
		}
		else{
			 query="from Product order by productId desc";
		}
		org.hibernate.query.Query<Product> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Product> list=query2.getResultList();
		System.out.println(list);
		return list;
	}
			

	public String deleteProduct(String productId) {
		// TODO Auto-generated method stub
		Session session = null;
		session=sessionFacotry.getCurrentSession();
		Product object = new Product();
		object.setProductId(productId);
		session.delete(object);
		return "sucess";
	}

	@Override
	public Product viewProduct(String productId) {
		// TODO Auto-generated method stub
		Session session = null;
		String query="from Product where productId=?";
		org.hibernate.query.Query<Product> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		query2.setParameter(0, productId);
		Product product = query2.getSingleResult();
		return product;
	}

	@Override
	@Transactional
	public String blockProduct(String productId) {
		// TODO Auto-generated method stub
		Session session = null;
		String query="select status from Product where productId=?";
		org.hibernate.query.Query<String> query2 = null;
		session=sessionFacotry.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, productId);
		String product = query2.getSingleResult();
		System.out.println(product);
		Product pro= session.get(Product.class, productId);
		if(product.equals("0")){
			pro.setStatus("1"); 
			System.out.println(pro);
			session.saveOrUpdate(pro); 
		}
		if(product.equals("1")){
			pro.setStatus("0"); 
			System.out.println(pro);
			session.saveOrUpdate(pro); 
		}
		return null;
	}

	@Override
	public List<Product> getProductByStatus() {
		// TODO Auto-generated method stub
		Session session =null;
		String query="from Product where status='0'";
		org.hibernate.query.Query<Product> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Product> list=query2.getResultList();
		return list;
	}

	@Override
	public List<Product> getProductbylowtohigh(String order) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if(order.equals("LowToHigh")){
		query="from Product where status='0' order by productId asc";
		}
		else{
			 query="from Product where status='0' order by productId desc";
		}
		org.hibernate.query.Query<Product> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Product> list=query2.getResultList();
		System.out.println(list);
		return list;
	}

}

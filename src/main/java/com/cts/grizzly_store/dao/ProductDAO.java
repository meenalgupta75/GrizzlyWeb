package com.cts.grizzly_store.dao;

import java.util.List;

import com.cts.grizzly_store.bean.Product;



public interface ProductDAO {

	public String insertProduct(Product product);
	public String deleteProduct(String productId);
	public Product viewProduct(String productId);
	public String blockProduct(String productId);
	public List<Product> getAllProduct();
	public List<Product> getProductByStatus();
	public List<Product> getProductById(String uderName, Product product);
	public List<Product> getAllProductbylowtohigh(String order);
	public List<Product> getProductbylowtohigh(String order);
}

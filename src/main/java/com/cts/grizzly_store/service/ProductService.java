package com.cts.grizzly_store.service;

import java.util.List;

import com.cts.grizzly_store.bean.Product;

public interface ProductService {

	public String insertProduct(Product product);
	public String deleteProduct(String productId);
	public Product viewProduct(String productId);
	public String blockProduct(String productId);
	public List<Product> getProductByStatus();
	public List<Product> getAllProduct();
	public List<Product> getAllProductbylowtohigh(String order);
	public List<Product> getProductbylowtohigh(String order);
	
}

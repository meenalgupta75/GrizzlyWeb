package com.cts.grizzly_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly_store.bean.Product;
import com.cts.grizzly_store.dao.ProductDAO;



@Service("productService")
@Transactional(propagation=Propagation.SUPPORTS)
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	@Override
	public String insertProduct(Product product) {
		
		// TODO Auto-generated method stub
		return productDAO.insertProduct(product);
	}
	
	@Override
	public List<Product> getAllProduct(){
		return productDAO.getAllProduct();
		
	}
		@Override
		public List<Product> getAllProductbylowtohigh(String order){
			return productDAO.getAllProductbylowtohigh(order);
		}

		@Override
		public String deleteProduct(String productId) {
			// TODO Auto-generated method stub
			return productDAO.deleteProduct(productId);
		}

		@Override
		public Product viewProduct(String productId) {
			// TODO Auto-generated method stub
			return productDAO.viewProduct(productId);
		}

		@Override
		public String blockProduct(String productId) {
			// TODO Auto-generated method stub
			return productDAO.blockProduct(productId);
		}

		@Override
		public List<Product> getProductByStatus() {
			// TODO Auto-generated method stub
			return productDAO.getProductByStatus();
		}

		@Override
		public List<Product> getProductbylowtohigh(String order) {
			// TODO Auto-generated method stub
			return productDAO.getProductbylowtohigh(order);
		}
	

}

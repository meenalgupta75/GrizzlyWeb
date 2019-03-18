package com.cts.grizzly_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzly_store.bean.Category;
import com.cts.grizzly_store.bean.Login;
import com.cts.grizzly_store.bean.Product;
import com.cts.grizzly_store.service.CategoryService;
import com.cts.grizzly_store.service.LoginService;
import com.cts.grizzly_store.service.ProductService;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	LoginService loginService;
	
//	@RequestMapping("Admin-AddProduct.html")
//	public String getProductPage(){
//		return "Admin-AddProduct";
//	}
	@RequestMapping("Admin-AddProduct12.html")						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView addPage(@ModelAttribute Product product){
		ModelAndView modelAndView = new ModelAndView();
	    /*Login login2= loginService.authenticate(login.getUserId(), login.getPassword());
		modelAndView.addObject("user", login2);*/
		modelAndView.addObject("category",categoryService.getAllCategory());
		modelAndView.setViewName("Admin-AddProduct");
		return modelAndView;
	}
	
	@RequestMapping("Vendor-AddProduct2.html")						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView vendorAddPage(@ModelAttribute Product product){
		ModelAndView modelAndView = new ModelAndView();
	    /*Login login2= loginService.authenticate(login.getUserId(), login.getPassword());
		modelAndView.addObject("user", login2);*/
		modelAndView.addObject("category",categoryService.getAllCategory());
		modelAndView.setViewName("Vendor-AddProduct2");
		return modelAndView;
	}
	
//	@RequestMapping("remove.html")
//	public ModelAndView remove(@ModelAttribute Product product)
//	{
//		ModelAndView modelAndView= new ModelAndView();
//		
//		return modelAndView;
//	}
	@RequestMapping("lowtohigh.html")
	public ModelAndView validateUser(@ModelAttribute Product product, @RequestParam("order") String order){
		ModelAndView modelAndView = new ModelAndView();
		
			List<Product> product1= productService.getAllProductbylowtohigh(order);
			modelAndView.addObject("products", product1);
			
			modelAndView.setViewName("Admin-ListProducts");
			return modelAndView;
	
	}
	
	@RequestMapping("hightolow.html")
	public ModelAndView validateVendor(@ModelAttribute Product product, @RequestParam("order") String order){
		ModelAndView modelAndView = new ModelAndView();
		
			List<Product> product1= productService.getProductbylowtohigh(order);
			modelAndView.addObject("products", product1);
			
			modelAndView.setViewName("Vendor-AddProduct");
			return modelAndView;
	}
	
	@RequestMapping("block.html")
	public ModelAndView blockProduct(@ModelAttribute Product product, @RequestParam("id") String productId){
		ModelAndView modelAndView = new ModelAndView();
		
			productService.blockProduct(productId);
			modelAndView.addObject("products", productService.getAllProduct());
			modelAndView.setViewName("Admin-ListProducts");
			return modelAndView;
	}
	
	@RequestMapping("unblock.html")
	public ModelAndView unblockProduct(@ModelAttribute Product product, @RequestParam("id") String productId){
		ModelAndView modelAndView = new ModelAndView();
		
			productService.blockProduct(productId);
			modelAndView.addObject("products", productService.getAllProduct());
			modelAndView.setViewName("Admin-ListProducts");
			return modelAndView;
	}
	
	@RequestMapping("remove.html")
	public ModelAndView removeProduct(@ModelAttribute Product product, @RequestParam("id") String productId){
		 	ModelAndView modelAndView = new ModelAndView();
			String product1= productService.deleteProduct(productId);
			if(product1.equals("sucess")){
				modelAndView.addObject("products", productService.getAllProduct());
			modelAndView.setViewName("Admin-ListProducts");
			return modelAndView;
			}
			else{
				modelAndView.setViewName("Admin-ListProducts");
				return modelAndView;
			}
		
	}
	
	@RequestMapping("view.html")
	public ModelAndView viewProduct(@ModelAttribute Product product, @RequestParam("id") String productId){
		 	ModelAndView modelAndView = new ModelAndView();
		 	modelAndView.addObject("products", productService.viewProduct(productId));
			modelAndView.setViewName("Admin-ViewProduct");
			return modelAndView;
	}
	
	@RequestMapping(value="Admin-AddProduct.html", method= RequestMethod.POST)						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView insertProduct(@ModelAttribute Product product){
		ModelAndView modelAndView = new ModelAndView();
		/*Login login = new Login();
		Login login2  = loginService.authenticate(login.getUserId(), login.getPassword());
		modelAndView.addObject("user", login2);*/
	
		productService.insertProduct(product);
		modelAndView.addObject("products", productService.getAllProduct());
			modelAndView.setViewName("Admin-ListProducts");
			//modelAndView.addObject("products",productService.getAllProduct());
		return modelAndView;
	}
	
	@RequestMapping(value="Vendor-AddProduct2.html", method= RequestMethod.POST)						//PostMapping(value="login.html", method= RequestMethod.GET)
	public ModelAndView vendorInsertProduct(@ModelAttribute Product product){
		ModelAndView modelAndView = new ModelAndView();
		/*Login login = new Login();
		Login login2  = loginService.authenticate(login.getUserId(), login.getPassword());
		modelAndView.addObject("user", login2);*/
	
		productService.insertProduct(product);
		modelAndView.addObject("products", productService.getProductByStatus());
			modelAndView.setViewName("Vendor-AddProduct");
			//modelAndView.addObject("products",productService.getAllProduct());
		return modelAndView;
	}
}
	
	


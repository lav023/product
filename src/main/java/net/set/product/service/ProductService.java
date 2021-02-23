package net.set.product.service;

import java.util.List;

import net.set.product.model.Product;

public interface ProductService {

	public Integer addProduct(Product p ) throws Exception;
	
	public List<Product > getProductName(String name) throws Exception;
	
	public List<Product > getProductcolor(String color) throws Exception;
	public List<Product > getProductCategory(String category) throws Exception;
	
}

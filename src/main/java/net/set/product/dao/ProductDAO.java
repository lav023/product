package net.set.product.dao;

import java.util.List;

import net.set.product.model.Product;

public interface ProductDAO {
	
	public Integer addProduct(Product p ) ;
	
	public List<Product > getProductName(String name);
	public List<Product > getProductcolor(String color);
	public List<Product > getProductCategory(String category);
	
}

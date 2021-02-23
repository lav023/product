package net.set.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.set.product.dao.ProductDAO;
import net.set.product.model.Product;
import net.set.product.validator.Validator;

@Service(value = "ProductService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO ;

	@Override
	public Integer addProduct(Product p) throws Exception {
		Validator.validate(p);
		 return productDAO.addProduct(p);
		
	}

	@Override
	public List<Product> getProductName(String name) throws Exception {
		
		List<Product> ret=productDAO.getProductName(name);
		if(ret.isEmpty()) {
			throw new Exception("No match found");
		}
		return ret ;
	}

	@Override
	public List<Product> getProductcolor(String color) throws Exception {
	
		List<Product> ret= productDAO.getProductcolor(color);
		
		if(ret.isEmpty()) {
			throw new Exception("No match found");
		}
		return ret ;
	}

	@Override
	public List<Product> getProductCategory(String category) throws Exception {
		
		List<Product> ret= productDAO.getProductCategory(category);
		
		if(ret.isEmpty()) {
			throw new Exception("No match found");
		}
		return ret ;
	}

}

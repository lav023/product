package net.set.product.validator;

import net.set.product.model.Product;

public class Validator {
	
	public static void validate(Product p) throws Exception {
		
		if(! p.getColor().matches("[A-Za-z ]+")) {
			throw new Exception("please enter valid color");
		}
		
		if(! p.getProductName().matches("[A-Za-z ]+")) {
			throw new Exception("please enter valid product name");
		}
		
		if(p.getPrice() <= 0 ) {
			throw new Exception("please enter correct price");
		}
	}
}

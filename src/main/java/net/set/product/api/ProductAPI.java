package net.set.product.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.set.product.model.Product;
import net.set.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductAPI {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/addProduct")
	public ResponseEntity<String> addProduct( @RequestBody Product product){
		
		try {
			Integer id=productService.addProduct(product);
			return new ResponseEntity<String>("product id"+id+" successfully",HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping(value="/getName/{name:.+}")
	public ResponseEntity<List<Product>> getProductName(@ PathVariable("name") String name){
		try {
			List<Product> ret= productService.getProductName(name);
			return new ResponseEntity<List<Product>>(ret,HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping(value="/getcolor/{color:.+}")
	public ResponseEntity<List<Product>> getProductColor(@ PathVariable("color") String color){
		try {
			List<Product> ret= productService.getProductcolor(color);
			return new ResponseEntity<List<Product>>(ret,HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping(value="/getcategory/{category:.+}")
	public ResponseEntity<List<Product>> getProductcategory(@ PathVariable("category") String category){
		try {
			List<Product> ret= productService.getProductCategory(category);
			return new ResponseEntity<List<Product>>(ret,HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
}

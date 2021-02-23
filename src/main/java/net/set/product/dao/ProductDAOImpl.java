package net.set.product.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import net.set.product.entity.CategoryEntity;
import net.set.product.entity.ProductEntity;
import net.set.product.model.Product;

@Repository(value="ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Integer addProduct(Product p) {
		
		
		ProductEntity pe= new ProductEntity();
		pe.setColor(p.getColor());
		pe.setPrice(p.getPrice());
		pe.setProductName(p.getProductName());
		entityManager.persist(pe);
		
		
		CategoryEntity ce= new CategoryEntity();
		ce.setCategoryType(p.getCategory());
		ce.setProduct(pe);
		entityManager.persist(ce);
		return pe.getProductId();
		
		
	}

	@Override
	public List<Product> getProductName(String name) {
		Query query = entityManager.createQuery(" Select p from ProductEntity p where p.productName=?1");
		List<ProductEntity> list= query.setParameter(1, name).getResultList();
		
		List<Product> pro= new ArrayList<Product>();
		
		for(ProductEntity pe:list) {
			Product p= new Product();
			p.setColor(pe.getColor());
			p.setPrice(pe.getPrice());
			p.setProductName(pe.getProductName());
			p.setProductId(pe.getProductId());
			pro.add(p);
		}
		return pro;
	}

	@Override
	public List<Product> getProductcolor(String color) {
		Query query = entityManager.createQuery(" Select p from ProductEntity p where p.color=?1");
		List<ProductEntity> list= query.setParameter(1, color).getResultList();
		List<Product> pro= new ArrayList<Product>();
		
		for(ProductEntity pe:list) {
			Product p= new Product();
			p.setColor(pe.getColor());
			p.setPrice(pe.getPrice());
			p.setProductName(pe.getProductName());
			p.setProductId(pe.getProductId());
			pro.add(p);
		}
		return pro;
	}

	@Override
	public List<Product> getProductCategory(String category) {
		
		Query query = entityManager.createQuery(" Select c.product from CategoryEntity c where c.categoryType=?1");
		List<ProductEntity> list= query.setParameter(1, category).getResultList();
		
		List<Product> pro= new ArrayList<Product>();
		
		for(ProductEntity pe:list) {
			Product p= new Product();
			p.setColor(pe.getColor());
			p.setPrice(pe.getPrice());
			p.setProductName(pe.getProductName());
			p.setProductId(pe.getProductId());
			pro.add(p);
		}
		return pro;
	}

	

}

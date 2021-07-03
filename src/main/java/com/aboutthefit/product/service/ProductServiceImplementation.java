/**
 * 
 */
package com.aboutthefit.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboutthefit.product.model.Product;
import com.aboutthefit.product.repository.ProductRepository;

/**
 * @author nisha
 *
 */
@Service
public class ProductServiceImplementation implements ProductService{

	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> getProducts() {
		return repo.findAllProducts();
	}

	@Override
	public Optional<Product> getProductById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Product> getFilteredProducts(String filterName, String filterValue) {
		switch(filterName) {
		case "name":
			return repo.findByName(filterValue);
		case "category":
			return repo.findByCategoryName(filterValue);
		}
		return null;
	}
}

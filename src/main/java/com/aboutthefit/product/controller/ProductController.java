/**
 * 
 */
package com.aboutthefit.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aboutthefit.product.model.Product;
import com.aboutthefit.product.service.ProductService;

@RequestMapping("/products")
@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/all")
	public List<Product> products(){
		return service.getProducts();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<Product>> productById(@PathVariable Integer id){
		Optional<Product> products = service.getProductById(id);
		return new ResponseEntity<Optional<Product>>(products,
				new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/filter/{filterName}/{filterValue}")
	public ResponseEntity<List<Product>> getFilteredProducts(
			@PathVariable String filterName, @PathVariable String filterValue){
		 List<Product> products = service.getFilteredProducts(filterName, filterValue);
		 return new ResponseEntity<List<Product>>(products,
					new HttpHeaders(), HttpStatus.OK);
	}
	
}

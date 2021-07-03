package com.aboutthefit.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aboutthefit.product.model.Product;

@Service
public interface ProductService {

	public List<Product> getProducts();

	public Optional<Product> getProductById(Integer id);

	public List<Product> getFilteredProducts(String filterName, String filterValue);

}

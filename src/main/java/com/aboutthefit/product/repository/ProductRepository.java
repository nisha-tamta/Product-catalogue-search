/**
 * 
 */
package com.aboutthefit.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aboutthefit.product.model.Product;

/**
 * @author nisha
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("FROM Product")
	List<Product> findAllProducts();

	List<Product> findByName(String filterValue);
	
	@Query("SELECT p FROM Product p JOIN Category c ON p.category.id = c.id WHERE c.name = :name")
	List<Product> findByCategoryName(@Param(value = "name") String name);
	
}

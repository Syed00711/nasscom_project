package com.microcare.nasscom_project.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microcare.nasscom_project.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	@Query("select p from Product p")
	Collection<Product> getAllProducts();
	
	@Query(value="select * from products where product_id = ?1 and category_id= ?2",nativeQuery=true)
	Product getByID(Integer p_id,Integer c_id);
	
}

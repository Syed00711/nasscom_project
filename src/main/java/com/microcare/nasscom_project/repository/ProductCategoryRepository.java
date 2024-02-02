package com.microcare.nasscom_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microcare.nasscom_project.model.ProductCategory;

import jakarta.persistence.NamedNativeQuery;

@Repository
public interface ProductCategoryRepository  
extends JpaRepository<ProductCategory,Integer>{
	
		ProductCategory findByCategoryName(String categoryName); 

}

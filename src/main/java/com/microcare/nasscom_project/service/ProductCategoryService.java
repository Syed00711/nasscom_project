package com.microcare.nasscom_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microcare.nasscom_project.model.Product;
import com.microcare.nasscom_project.model.ProductCategory;
import com.microcare.nasscom_project.repository.ProductCategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	public ResponseEntity<List<ProductCategory>> getAll(){
		List<ProductCategory> productCategories=productCategoryRepository.findAll();
		return new ResponseEntity<List<ProductCategory>>(productCategories,HttpStatus.OK);
	}
	
	public ResponseEntity<String> create(ProductCategory productCategory){
		productCategoryRepository.save(productCategory);
		return new ResponseEntity<String>("ENtity successfully created",HttpStatus.CREATED);
	}
	
	public ResponseEntity<ProductCategory> findByName(String CategoryName){
		System.out.println("SERVICE NAME"+CategoryName);
		ProductCategory productCategory=productCategoryRepository.findByCategoryName(CategoryName);
			if(productCategory == null) {
		
		return new ResponseEntity<ProductCategory>(HttpStatus.NOT_FOUND);
		}
		else {
			productCategory.setCategoryName(productCategory.getCategoryName()+" 3287412471");
			
			System.out.println("PC ID"+productCategory.getCategoryId());
			return new ResponseEntity<ProductCategory>(productCategory,HttpStatus.OK);
			
		}
	}
	
	
}

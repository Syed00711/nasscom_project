package com.microcare.nasscom_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	
}

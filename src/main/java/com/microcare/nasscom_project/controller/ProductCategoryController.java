package com.microcare.nasscom_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcare.nasscom_project.model.ProductCategory;
import com.microcare.nasscom_project.service.ProductCategoryService;

@RestController
@RequestMapping("/product_category")
public class ProductCategoryController {
	@Autowired
	ProductCategoryService productCategoryService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<ProductCategory>> get(){
		return productCategoryService.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody ProductCategory productCategory){
		return productCategoryService.create(productCategory);
	}
	
	

}

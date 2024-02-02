package com.microcare.nasscom_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcare.nasscom_project.dto.ProductDTO;
import com.microcare.nasscom_project.model.Product;
import com.microcare.nasscom_project.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService; 
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Product>> fetchAll(){
		return productService.fetchAll();
	}
	@GetMapping("/count")
	public ResponseEntity<Long> getTotalCount(){
		return productService.getCount();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Product> findById( @PathVariable("id") Integer productId){
		return productService.findById(productId);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO productdto) {
		
		
		return productService.create(productdto);
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> delete(@PathVariable("productId") Integer productId){
		return productService.deleteProduct(productId);
	}

}

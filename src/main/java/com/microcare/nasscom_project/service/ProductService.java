package com.microcare.nasscom_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microcare.nasscom_project.model.Product;
import com.microcare.nasscom_project.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepository; 
	
	public ResponseEntity<List<Product>> fetchAll(){
		
		return new ResponseEntity<List<Product>>(productRepository.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<Long> getCount(){
		
		return new ResponseEntity<Long>(productRepository.count(),HttpStatus.OK);
	}
	
	public ResponseEntity<Product> findById(Integer productId){
		Optional<Product> product=productRepository.findById(productId);
		
		if(product.isEmpty()) {
		
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Product>((Product)productRepository.findById(productId).get(),HttpStatus.OK);
			
		}
	}

}

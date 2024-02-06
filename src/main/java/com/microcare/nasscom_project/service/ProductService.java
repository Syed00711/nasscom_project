package com.microcare.nasscom_project.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microcare.nasscom_project.dto.ProductDTO;
import com.microcare.nasscom_project.model.Product;
import com.microcare.nasscom_project.repository.ProductCategoryRepository;
import com.microcare.nasscom_project.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductRepository productRepository; 
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
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
	
	public ResponseEntity<String> create( ProductDTO productdto ){
		Product product =new Product();
		product.setProductName(productdto.getProductName());
		product.setListPrice(productdto.getListPrice());
		product.setStandardCost(productdto.getStandardCost());
		product.setDescription(productdto.getDescription());
		
		product.setProductCategory(productCategoryRepository.findById(productdto.getCategoryId()).get());
		
		
		productRepository.save(product);
		return new ResponseEntity<String>("Product Successfully created",HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> deleteProduct(Integer productId){
		productRepository.deleteById(productId);
		return new ResponseEntity<String>("Deleted Product ",HttpStatus.OK);
	}
	
	
	public ResponseEntity<Collection<Product>> getProducts(){
		return new ResponseEntity<Collection<Product>>(productRepository.getAllProducts(),HttpStatus.OK);
	}
	
	public ResponseEntity<Product> getNativeProducts(Integer p_id,Integer c_id){
		return new ResponseEntity<Product>(productRepository.getByID(p_id,c_id),HttpStatus.OK);
	}

}

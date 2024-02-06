package com.microcare.nasscom_project.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microcare.nasscom_project.model.Order;
import com.microcare.nasscom_project.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public ResponseEntity<List<Order>> findAll(){
		List<Order> orders=orderRepository.findAll();
		
		return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
	}
	
	public ResponseEntity<Collection<Order>> findByDates(LocalDate from,LocalDate to){
		System.out.println(from.toString()+":::::::"+to.toString());
		Collection<Order> orders=orderRepository.findByOrderDateRange(from,to);
		
		return new ResponseEntity<Collection<Order>>(orders,HttpStatus.OK);
	}

}

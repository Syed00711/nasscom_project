package com.microcare.nasscom_project.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microcare.nasscom_project.model.Order;
import com.microcare.nasscom_project.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Order>> findAll(){
		return orderService.findAll();
	}
	
	@GetMapping("/orderbydate")
	public ResponseEntity<Collection<Order>> findOrderByDates
	(@RequestParam("from")@DateTimeFormat(pattern = "dd-MM-yy") LocalDate from,@RequestParam("to")@DateTimeFormat(pattern = "dd-MM-yy") LocalDate to){
		return orderService.findByDates(from, to);
	}

}

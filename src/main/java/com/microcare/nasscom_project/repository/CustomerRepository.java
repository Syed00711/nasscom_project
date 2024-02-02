package com.microcare.nasscom_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microcare.nasscom_project.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}

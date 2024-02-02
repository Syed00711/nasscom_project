package com.microcare.nasscom_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microcare.nasscom_project.model.Contact;


@Repository
public interface ContactRepository 
extends JpaRepository<Contact,Integer>{

}

package com.microcare.nasscom_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microcare.nasscom_project.model.Contact;
import com.microcare.nasscom_project.repository.ContactRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContactService {
	
	@Autowired
	ContactRepository contactRepository;
	
	
	public ResponseEntity<Contact> getByContactId(Integer contactId){
		return new ResponseEntity<Contact>(contactRepository.findById(contactId).get(),HttpStatus.OK);
	}

}

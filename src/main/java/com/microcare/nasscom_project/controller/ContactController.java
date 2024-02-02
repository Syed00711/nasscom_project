package com.microcare.nasscom_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microcare.nasscom_project.model.Contact;
import com.microcare.nasscom_project.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	
	@GetMapping("/contactid/{contactId}")
	public ResponseEntity<Contact> getByContactId(@PathVariable("contactId") Integer contactId){
		return contactService.getByContactId(contactId);
	}

}

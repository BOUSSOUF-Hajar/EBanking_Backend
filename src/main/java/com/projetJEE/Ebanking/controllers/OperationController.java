package com.projetJEE.Ebanking.controllers;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projetJEE.Ebanking.entities.*;
import com.projetJEE.Ebanking.exceptions.*;
import com.projetJEE.Ebanking.services.*;

@CrossOrigin(origins = "*")
@RestController
public class OperationController {
	
	
	OperationService service;
	
	@Autowired
	public OperationController(OperationService service) {
		
		this.service=service;
	}
	
	//GET
			
			
			
			@GetMapping(value="/operationsPDF/{id}", produces = "application/pdf")
			@ResponseStatus(HttpStatus.OK)
			public ResponseEntity<InputStreamResource> getRecuOperationPDF(@PathVariable(name="id") Long id) throws IOException
			{
				return service.getRecuOperationPDF(id);
			}
			
			
		
		
		//POST
			
			@RequestMapping(value = "/operations/save" , method = RequestMethod.POST, consumes = { "application/json"})//"multipart/form-data" ,"application/json"
			@ResponseStatus(HttpStatus.CREATED)
			public void addOperation(@RequestBody Operation operation)  throws Exception, AlreadyExistsException
			{
				service.addOperation(operation);
			}
		
		
		


}


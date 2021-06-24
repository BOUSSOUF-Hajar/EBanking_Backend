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
public class VirementController {
	
	
	VirementService service;
	
	@Autowired
	public VirementController(VirementService service) {
		
		this.service=service;
	}
	
	//GET
			@GetMapping("/virements")
			@ResponseStatus(HttpStatus.OK)
			public List<Virement> getVirements(@RequestParam(name="id", required=false) Long id) throws NotFoundException
			{
				return service.getVirements(id);
			}
			
			
			@GetMapping(value="/virementsPDF/{id}", produces = "application/pdf")
			@ResponseStatus(HttpStatus.OK)
			public ResponseEntity<InputStreamResource> getRecuVirementPDF(@PathVariable(name="id") Long id) throws IOException
			{
				return service.getRecuVirementPDF(id);
			}
			
			
		
		
		//POST
			
			@RequestMapping(value = "/virements/save" , method = RequestMethod.POST, consumes = { "application/json"})//"multipart/form-data" ,"application/json"
			@ResponseStatus(HttpStatus.CREATED)
			public void addVirement(@RequestBody Virement virement)  throws Exception, AlreadyExistsException
			{
				service.addVirement(virement);
			}
		
		
		


}


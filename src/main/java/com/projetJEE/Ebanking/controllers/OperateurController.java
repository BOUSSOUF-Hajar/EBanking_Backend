package com.projetJEE.Ebanking.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.projetJEE.Ebanking.entities.*;
import com.projetJEE.Ebanking.exceptions.*;
import com.projetJEE.Ebanking.services.*;

@CrossOrigin("*")
@RestController
public class OperateurController {
	
	
	OperateurService service;
	
	@Autowired
	public OperateurController(OperateurService service) {
		
		this.service=service;
	}
	
	//GET
			
			
			
			@GetMapping("/operateurs/username/{username}")
			@ResponseStatus(HttpStatus.OK)
			public Operateur getByUsername(@PathVariable(name="username") String username)
			{
				return service.getByUsername(username);
			}
			
			
			
			@GetMapping("/operateurs/{id}/comptes")
			@ResponseStatus(HttpStatus.OK)
			public List<Compte> getComptes(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getComptes(id);
			}
			
		
		
		//POST
			
			@RequestMapping(value = "/operateurs/save" , method = RequestMethod.POST, consumes = { "application/json"})//"multipart/form-data" ,"application/json"
			@ResponseStatus(HttpStatus.CREATED)
			public void addOperateur(@RequestBody Operateur operateur)  throws AlreadyExistsException
			{
				service.addOperateur(operateur);
			}
		
		
		
		//PUT
			
			@PutMapping("/operateurs/save/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void updateOperateur(@PathVariable Long id , @RequestBody(required=false) Operateur operateur)  throws NotFoundException, AlreadyExistsException
			{
				service.updateOperateur(id,operateur);
			}
	
		
			
		//DELETE
			
			@DeleteMapping("/operateurs/delete/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void deleteOperateur(@PathVariable Long id) throws NotFoundException
			{
				service.removeOperateur(id);
			}
			
	

}


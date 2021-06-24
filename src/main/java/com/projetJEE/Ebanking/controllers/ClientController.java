package com.projetJEE.Ebanking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.projetJEE.Ebanking.entities.*;
import com.projetJEE.Ebanking.exceptions.*;
import com.projetJEE.Ebanking.services.*;

@CrossOrigin("*")
@RestController
public class ClientController {
	
	
	ClientService service;
	
	@Autowired
	public ClientController(ClientService service) {
		
		this.service=service;
	}
	
	//GET
			
			
			
			@GetMapping("/clients/username/{username}")
			@ResponseStatus(HttpStatus.OK)
			public Client getByUsername(@PathVariable(name="username") String username)
			{
				return service.getByUsername(username);
			}
			
			
			
			@GetMapping("/client/{id}/comptes")
			@ResponseStatus(HttpStatus.OK)
			public List<Compte> getComptes(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getComptes(id);
			}
			
		
		
		//POST
			 
			@RequestMapping(value = "/clients/save" , method = RequestMethod.POST, consumes = { "application/json"})//"multipart/form-data" ,"application/json"
			@ResponseStatus(HttpStatus.CREATED)
			public void addClient(@RequestBody Client client)  throws AlreadyExistsException
			{
				service.addClient(client);
			}
		
		
		
		//PUT
			
			@PutMapping("/clients/update/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void updateClient(@PathVariable(name="id") Long id , @RequestBody(required=false) Client client)  throws NotFoundException, AlreadyExistsException
			{
				service.updateClient(id,client);
			}
	
		
			
		//DELETE
			
			@DeleteMapping("/clients/delete/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void deleteClient(@PathVariable(name="id") Long id) throws NotFoundException
			{
				service.removeClient(id);
			}
			
	

}


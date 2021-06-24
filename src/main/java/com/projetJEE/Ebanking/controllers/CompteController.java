package com.projetJEE.Ebanking.controllers;

import java.io.FileNotFoundException;
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
import com.itextpdf.text.DocumentException;

@CrossOrigin(origins = "*")
@RestController
public class CompteController {
	
	
	CompteService service;
	
	@Autowired
	public CompteController(CompteService service) {
		
		this.service=service;
	}
	
	//GET
			@GetMapping("/comptes")
			@ResponseStatus(HttpStatus.OK)
			public List<Compte> getComptes(@RequestParam(name="id", required=false) Long id) throws NotFoundException
			{
				return service.getComptes(id);
			}
			
			
			@GetMapping("/comptes/{numero}/total")
			@ResponseStatus(HttpStatus.OK)
			public Compte getCompteByNumero(@PathVariable(name="numero") String numero)
			{
				return service.getCompteByNumero(numero);
			}
			
			
			
			@GetMapping("/comptes/{id}/virements")
			@ResponseStatus(HttpStatus.OK)
			public List<Virement> getVirements(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getVirements(id);
			}
			
			
			@GetMapping("/comptes/{id}/virementsEnvoyes")
			@ResponseStatus(HttpStatus.OK)
			public List<Virement> getVirementsEnvoyes(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getVirementsEnvoyes(id);
			}
			
			
			@GetMapping("/comptes/{id}/virementsRecus")
			@ResponseStatus(HttpStatus.OK)
			public List<Virement> getVirementsRecus(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getVirementsRecus(id);
			}
			
			
			
			@GetMapping("/comptes/{id}/recharges")
			@ResponseStatus(HttpStatus.OK)
			public List<Recharge> getRecharges(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getRecharges(id);
			}
			
			
			@GetMapping("/comptes/{id}/operations")
			@ResponseStatus(HttpStatus.OK)
			public List<Operation> getOperations(@PathVariable(name="id") Long id) throws NotFoundException
			{
				return service.getOperations(id);
			}
			
			
			
			@GetMapping(value="/contratPDF/{id}", produces = "application/pdf")
			@ResponseStatus(HttpStatus.OK)
			public ResponseEntity<InputStreamResource> getContratPDF(@PathVariable(name="id") Long id) throws IOException
			{
				return service.getContratPDF(id);
			}
			
			
		
		
		//POST
			
			@PostMapping("/comptes")
			@ResponseStatus(HttpStatus.CREATED)
			public void addCompte(@RequestBody Compte compte)  throws AlreadyExistsException, DocumentException, FileNotFoundException
			{
				service.addCompte(compte);
			}
		
		
		
		//PUT
			
			@PutMapping("/comptes/add/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void updateCompte(@PathVariable Long id , @RequestBody(required=false) Compte compte)  throws NotFoundException, AlreadyExistsException
			{
				service.updateCompte(id,compte);
			}
	
		
			
		//DELETE
			
			@DeleteMapping("/comptes/delete/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void deleteCompte(@PathVariable Long id) throws NotFoundException
			{
				service.removeCompte(id);
			}
			
	

}


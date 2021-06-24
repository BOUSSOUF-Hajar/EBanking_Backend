package com.projetJEE.Ebanking.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.projetJEE.Ebanking.entities.*;
import com.projetJEE.Ebanking.services.*;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {
	
	
	AdminService service;
	
	@Autowired
	public AdminController(AdminService service) {
		
		this.service=service;
	}
	
	//GET
			@GetMapping("/admins")
			@ResponseStatus(HttpStatus.OK)
			public List<Admin> getAdmins(@RequestParam(name="id", required=false) Long id)
			{
				return service.getAdmins(id);
			}
			
			
			@GetMapping("/admin/username/{username}")
			@ResponseStatus(HttpStatus.OK)
			public Admin getByUsername(@PathVariable(name="username") String username)
			{
				return service.getByUsername(username);
			}
			
			

		
		//POST
			
			@RequestMapping(value = "/admins/save" , method = RequestMethod.POST, consumes = { "application/json"})//"multipart/form-data" ,"application/json"
			@ResponseStatus(HttpStatus.CREATED)
			public void addAdmin(@RequestBody Admin admin)
			{
				service.addAdmin(admin);
			}
		
		
		
		//PUT
			
			@PutMapping("/admin/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void updateAdmin(@PathVariable Long id , @RequestBody(required=false) Admin admin)
			{
				service.updateAdmin(id,admin);
			}
	
		
			
		//DELETE
			
			@DeleteMapping("/admin/{id}")
			@ResponseStatus(HttpStatus.OK)
			public void deleteAdmin(@PathVariable Long id)
			{
				service.removeAdmin(id);
			}
			
	

}


package com.projetJEE.Ebanking.services;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.PathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projetJEE.Ebanking.entities.*;
import com.projetJEE.Ebanking.exceptions.AlreadyExistsException;
import com.projetJEE.Ebanking.exceptions.NotFoundException;
import com.projetJEE.Ebanking.Dao.*;

@Service
public class OperationService {
	

	@Autowired
	DeviseRepository  Drep;
	@Autowired
	CompteRepository  Crep;
	@Autowired
	OperationRepository rep;
	
	@Autowired
	CompteService compteService;
	
	@Autowired
	AgentService agentService;
	
	@Autowired
	DeviseService deviseService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	RecuOperationService recuService;
	
	
	Logger logger = LoggerFactory.getLogger(RechargeService.class.getName());
	
	
	public List<Operation> getOperations(Long id)  throws NotFoundException
	{
		
		List<Operation> operations= new ArrayList<Operation>();	
		
		if(id!=null)
			operations.add(rep.findById(id).orElseThrow(() -> new NotFoundException("Aucun operation avec l'id "+id+" trouvé")));
		
		else
			operations=rep.findAll();
		
		if(operations.isEmpty())  throw new NotFoundException("Aucun operation trouvé");
		return operations;
	}
		
	
	
	public void addOperation(Operation operation) throws Exception, AlreadyExistsException
	{
		Compte compte = compteService.getComptes(operation.getCompte().getId()).get(0);
		Client c= clientService.getClients(compte.getProprietaire().getId()).get(0);
		Devise devise = deviseService.getDevises(operation.getDevise().getId()).get(0);
		//Agent agent = agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		Agent agent = agentService.getByUsername("alain");
		if(operation.getType().equals("Retrait"))
		{
			if(compte.getSolde() < operation.getSommeCompte()) throw new Exception("Vous n'avez pas de solde suffisant ! ");
			
			operation.setDate(LocalDateTime.now());
			Drep.save(operation.getDevise());
			Crep.save(operation.getCompte());
			rep.save(operation);	
			compte.setSolde(compte.getSolde() - operation.getSommeCompte());
			List<Compte> comptes=Crep.findByProprietaire(c);
			comptes.add(compte);
			c.setComptes(comptes);
			compte.setProprietaire(c);
			
			

		}
		if(operation.getType().equals("Versement"))
		{
			
			operation.setDate(LocalDateTime.now());
			Drep.save(operation.getDevise());
			Crep.save(operation.getCompte());
			rep.save(operation);	
			compte.setSolde(compte.getSolde() + operation.getSommeCompte());
			List<Compte> comptes=Crep.findByProprietaire(c);
			comptes.add(compte);
			c.setComptes(comptes);
			compte.setProprietaire(c);
			
		}		
		
		compteService.rep.save(compte);
		
		recuService.CreateRecu(operation);
		
		
//		logger.debug("L'agent "+agent.getNom()+" "+agent.getPrenom()+" ayant le Username "+agent.getUsername()
//		+" a effectué un "+operation.getType()+" de "+operation.getSommeEspece()+devise.getCode()+" à la date "+operation.getDate()+" en faveur du compte "
//			+compte.getNumero());
		
		
	}
	
	
	public ResponseEntity<InputStreamResource> getRecuOperationPDF(Long id) throws IOException
	{
		Operation operation = getOperations(id).get(0);
		Compte compte = compteService.getComptes(operation.getCompte().getId()).get(0);
		
		String fileName = operation.getType()+"_"+compte.getNumero()+"_"+operation.getDate().toString().replace(':', '-')+".pdf";
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		
		PathResource pdfFile = new PathResource(path+"\\src\\main\\resources\\recu\\recu-operation\\"+fileName);
		 	
		
		  ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
		    new InputStreamResource(pdfFile.getInputStream()), HttpStatus.OK);
		  Agent agent = agentService.getByUsername("alain");
		  //Agent agent = agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		logger.debug("L'agent "+agent.getNom()+" "+agent.getPrenom()+" ayant le Username "+agent.getUsername()+" a téléchargé le fichier "+fileName+" à la date: "+LocalDateTime.now());
			
		  
		  return response;

	}
	

}

package com.projetJEE.Ebanking.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetJEE.Ebanking.entities.Client;

@CrossOrigin("*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
	@RestResource(path="up")
	public Client findByUsernameAndPassword(@Param("u") String username,@Param("p") String password );
	//http://localhost:8080/clients/search/up?u=admin&p=madagascar
	@RestResource(path="up2")
	@Query("select c.id from Client c where c.username like :u and c.password like :p")
	public Long chercher(@Param("u") String username,@Param("p") String password );
	//http://localhost:8080/clients/search/up?u=admin&p=madagascar
	
	Optional<Client> findByUsername(String username);

	Optional<Client> findByCin(String username);
}

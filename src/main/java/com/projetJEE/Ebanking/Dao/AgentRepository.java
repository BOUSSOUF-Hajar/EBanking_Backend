package com.projetJEE.Ebanking.Dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetJEE.Ebanking.entities.Agent;
@CrossOrigin("*")
@RepositoryRestResource
public interface AgentRepository extends JpaRepository<Agent, Long> {
	@RestResource(path="up3")
	public Agent findByUsernameAndPassword(@Param("u") String username,@Param("p") String password );
	
	//http://localhost:8080/agents/search/up3?u=alain&p=delon
	@RestResource(path="up4")
	@Query("select c.id from Agent c where c.username like :u and c.password like :p")
	public Long chercher(@Param("u") String username,@Param("p") String password );
	
	//http://localhost:8080/agents/search/up?u=alain&p=delon
	@RestResource(path="up")
	@Query("select c.agence.id from Agent c where c.username like :u and c.password like :p")
	public Long agence(@Param("u") String username,@Param("p") String password );
	//http://localhost:8080/agents/search/up?u=alain&p=delon
	
	Optional<Agent> findByUsername(String username);

	Optional<Agent> findByCin(String username);
}

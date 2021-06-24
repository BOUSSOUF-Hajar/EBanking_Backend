package com.projetJEE.Ebanking.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projetJEE.Ebanking.entities.Client;
import com.projetJEE.Ebanking.entities.Compte;
@CrossOrigin("*")
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
	Optional<Compte> findByNumero(String numero);
	@RestResource(path="up6")
	@Query("select c.devise.code from Compte c where c.id = :u")
	public String chercher(@Param("u") long id);
	//http://localhost:8080/comptes/search/up6?u=1
	List<Compte> findByProprietaire(Client c);
	@RestResource(path="up9")
	@Query("select c.proprietaire from Compte c where c.id = :u")
	public Client chercher2(@Param("u") long id);
	//http://localhost:8080/comptes/search/up9?u=1
}

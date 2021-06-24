package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface OperationRepository extends JpaRepository<Operation, Long> {

	@RestResource(path="up7")
	@Query("select o.compte.proprietaire from Operation o where o.id = :u ")
	public Client chercher(@Param("u") long id);
	//http://localhost:8080/operations/search/up7?u=1
}

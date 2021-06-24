package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface OperateurRepository extends JpaRepository<Operateur, Long> {
	
	Optional<Operateur> findByUsername(String username);

	Optional<Operateur> findByCin(String username);

}

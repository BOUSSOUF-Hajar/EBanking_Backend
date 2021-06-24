package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepository extends JpaRepository<Utilisateur, Long> {
	
	Optional<Utilisateur> findByUsername(String username);

}

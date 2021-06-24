package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Optional<Admin> findByUsername(String username);

	Optional<Admin> findByCin(String cin);

}

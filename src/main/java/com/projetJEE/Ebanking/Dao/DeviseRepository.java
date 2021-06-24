package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface DeviseRepository extends JpaRepository<Devise, Long> {

	
	Optional<Devise> findByCode(String code);
	
	void deleteByCode(String code);
	
	//recherche par code ISO, langue et code Banque 
	Optional<Devise> findByIsoCodeAndBankCodeAndLangue(String isoCode, String bankCode, String langue);
	
	//recherche par code ALPHA, langue et code Banque 
	Optional<Devise> findByAlphaCodeAndBankCodeAndLangue(String alphaCode, String bankCode, String langue);

	
	
	
}

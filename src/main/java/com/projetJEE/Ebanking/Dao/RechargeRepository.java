package com.projetJEE.Ebanking.Dao;

import com.projetJEE.Ebanking.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RechargeRepository extends JpaRepository<Recharge, Long> {
	
	
}

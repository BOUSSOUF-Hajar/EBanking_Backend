package com.projetJEE.Ebanking.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="OPERATEUR")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Operateur extends Client{
	private int numeroOperateur;
	
		

}

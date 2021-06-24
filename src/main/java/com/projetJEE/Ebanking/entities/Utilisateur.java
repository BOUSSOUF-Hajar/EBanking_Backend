package com.projetJEE.Ebanking.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor @AllArgsConstructor @ToString @Setter
public @Data abstract class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String nom;
	String prenom;
	String cin;
	String adresse;
	String telephone;
	String email;
	@Column(nullable=false)
	String username;
	@Column(nullable=false)
	String password;
	@Column(nullable=false)
	String role;
}

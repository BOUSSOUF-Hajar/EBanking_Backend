package com.projetJEE.Ebanking.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="CLIENT")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "ID_CLIENT")),
    @AttributeOverride(name = "nom", column = @Column(name = "NOM_CLIENT")),
    @AttributeOverride(name = "prenom", column = @Column(name = "PRENOM_CLIENT")),
    @AttributeOverride(name = "cin", column = @Column(name = "CIN_CLIENT")),
    @AttributeOverride(name = "adresse", column = @Column(name = "ADRESSE_CLIENT")),
    @AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE_CLIENT")),
    @AttributeOverride(name = "email", column = @Column(name = "EMAIL_CLIENT")),
    @AttributeOverride(name = "username", column = @Column(name = "USERNAME_CLIENT")),
    @AttributeOverride(name = "password", column = @Column(name = "PASSWORD_CLIENT")),
   // @AttributeOverride(name = "role", column = @Column(name = "ROLE_CLIENT"))
})
@Inheritance(strategy = InheritanceType.JOINED)
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client  extends Utilisateur{
	
	@Column(name="EST_OPERATEUR_CLIENT")
	String estOperateur;
	
	@ToString.Exclude
	@JoinColumn(name="CREATION_AGENT_CLIENT")
	@ManyToOne
	Agent creationAgent;

	@ToString.Exclude
	@JoinColumn(name="AGENCE_CLIENT")
	@ManyToOne
	Agence agence;
	
	@ToString.Exclude
	@JsonIgnore
	@Column(name="COMPTES_CLIENT")
	@OneToMany(mappedBy="proprietaire",cascade=CascadeType.ALL)
	List<Compte> comptes;
	
	
	
}

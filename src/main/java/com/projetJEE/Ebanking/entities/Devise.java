package com.projetJEE.Ebanking.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.format.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="DEVISE")@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Devise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DEVISE")
	Long id;
	
	@Column(name="CODE_DEVISE")
	String code;
	
	@Column(name="NOM_DEVISE")
	String nom;
	
	@Column(name="LANGUE_DEVISE")
	String langue;
	
	@Column(name="ALPHA_CODE_DEVISE")
	String alphaCode;
	
	@Column(name="ISO_CODE_DEVISE")
	String isoCode;
	
	@Column(name="BANK_CODE_DEVISE")
	String bankCode="MA001";
	
	@Column(name="PAYS_CODE_DEVISE")
	String paysCode="MA";
	
	@Column(name="CREATION_DATE_DEVISE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDateTime creationDate;
	
	@ManyToOne
	@JoinColumn(name="CREATION_ADMIN_DEVISE")
	Admin creationAdmin;
	
	@Column(name="MODIFICATION_DATE_DEVISE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDateTime modificationDate;
	
	@ManyToOne
	@JoinColumn(name="MODIFICATION_ADMIN_DEVISE")
	Admin modificationAdmin;
	

}

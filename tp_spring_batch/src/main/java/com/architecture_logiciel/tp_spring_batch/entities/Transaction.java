package com.architecture_logiciel.tp_spring_batch.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
	@Id
	private int idTransaction; 
	
	private float montant; 
	private LocalDateTime dateTransaction;
	@Transient
	private String dateTransactionString; 
	private LocalDateTime dateDebit; 
	

	private int idCompte; 
	
//	@ManyToOne()
//	private Compte compte; 
}

package com.architecture_logiciel.tp_spring_batch.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Compte {
	@Id
	private int idCompte; 
	private float solde; 
	
	@OneToMany()
	private Set<Transaction> transactions = new HashSet<>(); 
}

package com.tpSpringAop.bankManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
	private double solde; 
	
	public void debiter (double  mt) {
		solde-=mt;
	}
	
	public void approvisionner (double  mt) {
		solde+=mt;
	}
}

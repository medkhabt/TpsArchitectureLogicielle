package com.tpSpringAop.bankManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	private String nom; 
	private Compte cp; 
	
	public void retirer(double mt) {
		cp.debiter(mt);
	}

	public void verser(double mt) {
		cp.approvisionner(mt);
	}
}




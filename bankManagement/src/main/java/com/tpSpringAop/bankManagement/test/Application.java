package com.tpSpringAop.bankManagement.test;

import com.tpSpringAop.bankManagement.entities.Client;
import com.tpSpringAop.bankManagement.entities.Compte;

public class Application {

	public static void main(String[] args) {
		new Application().start(); 
		
	}

	private void start() {
		System.out.println("Demarrage de l'application");
		
		Compte compte = new Compte(1000); 
		Client client = new Client("Med", compte); 
		
		client.retirer(400);
		client.verser(100);
	}

}

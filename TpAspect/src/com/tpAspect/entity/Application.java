package com.tpAspect.entity;

import org.apache.log4j.Logger;


public class Application {
	static Logger log = Logger.getLogger(Application.class.getName()); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte compte = new Compte(1000); 
		Client client = new Client("Mes", compte) ;
		
		client.retirer(400);
		client.retirer(2000);
		client.verser(200);;
		

	}
	
	
}

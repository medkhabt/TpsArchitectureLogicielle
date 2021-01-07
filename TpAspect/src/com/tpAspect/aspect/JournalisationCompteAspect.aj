package com.tpAspect.aspect;


import java.util.Date;

import org.apache.log4j.Logger;

import com.tpAspect.entity.Client;
import com.tpAspect.entity.Compte;







public aspect JournalisationCompteAspect {
	static Logger log = Logger.getLogger(JournalisationCompteAspect.class.getClass()); 
	
	
	pointcut callRetirer(double mt, Client client) : 
		call(void *..retirer(double)) && args(mt) && target(client);
	
	pointcut callVerser(double mt, Client client) : 
		call(void *..verser(double)) && args(mt) && target(client); 
	
	Object around(double mt, Client client): 
		callRetirer(mt, client) {
		
		log.info("************* Retirer une somme d'argent du compte ************");
		log.info("Client: " + client.getNom());
		Date startDate = new Date();
		if(mt < client.getCp().getSolde()) { 
			Object ret = proceed(mt, client);
			log.info("La somme retiree est: " + mt);
			log.info("Le solde actuel est: " + client.getCp().getSolde());
			log.info("-- temps d'execution: " + (System.currentTimeMillis() - startDate.getTime()) + " ms");
			return ret;	
		}
		else { 
			log.error("Votre solde est insuffisant");
			return null; 
		}	
	}
	
	Object around(double mt, Client client):
		callVerser(mt,client) { 
		log.info("************* Verser une somme d'argent au compte ************");
		log.info("Client: " + client.getNom());
		Date startDate = new Date(); 
		Object ret = proceed(mt, client); 
		log.info("La somme versee est: " + mt);
		log.info("Le solde actuel est: " + client.getCp().getSolde());
		log.info("-- temps d'execution: " + (System.currentTimeMillis() - startDate.getTime()) + " ms");
		return ret; 
	}
	
	
}

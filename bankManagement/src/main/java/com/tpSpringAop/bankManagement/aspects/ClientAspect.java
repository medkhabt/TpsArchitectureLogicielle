package com.tpSpringAop.bankManagement.aspects;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.tpSpringAop.bankManagement.entities.Client;


@Aspect
@Component
public class ClientAspect {
	
	static Logger log = Logger.getLogger(ClientAspect.class.getClass()); 
	@Pointcut(value = "execution(void com.tpSpringAop.bankManagement.entities.*.retirer(..))")
	public void callRetirer() {}
	
	@Pointcut(value = "execution(void com.tpSpringAop.bankManagement.entities.*.verser(..))")
	public void callVerser() {}
	
	
	@Around("callRetirer()")
	public Object retirerLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		Object ret;
		Client client = (Client)proceedingJoinPoint.getTarget(); 
		Object[] array = proceedingJoinPoint.getArgs(); 
		double mt  = (double) array[0]; 
		
		log.info("Client: " + client.getNom());
		
		Date startDate = new Date();
		log.info("************* Retirer une somme d'argent du compte ************");
		try {
			if(mt < client.getCp().getSolde()) { 
				ret = proceedingJoinPoint.proceed();
				log.info("La somme retiree est: " + mt);
				log.info("Le solde actuel est: " + client.getCp().getSolde());
				log.info("-- temps d'execution: " + (System.currentTimeMillis() - startDate.getTime()) + " ms");
			}
			else { 
				log.error("Votre solde est insuffisant");
				ret = null; 
			}
			
		} catch (Throwable e) {
			throw e; 
		}
		return ret; 
	}
}

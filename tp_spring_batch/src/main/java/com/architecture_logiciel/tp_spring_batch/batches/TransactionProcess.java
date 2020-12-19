package com.architecture_logiciel.tp_spring_batch.batches;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.architecture_logiciel.tp_spring_batch.entities.Compte;
import com.architecture_logiciel.tp_spring_batch.entities.Transaction;
import com.architecture_logiciel.tp_spring_batch.repositories.CompteRepository;

@Component
public class TransactionProcess implements ItemProcessor<Transaction,Transaction>{
	
	// i should probably add a service , instead of autowiring the repositoy 
	@Autowired
	private CompteRepository compteRepository ;
	
	
	@Override
	public Transaction process(Transaction transaction) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //02/01/2015 23:15 
				
		transaction.setDateTransaction(LocalDateTime.parse(transaction.getDateTransactionString(), formatter));
		transaction.setDateDebit(LocalDateTime.now());
		
		int compteId = transaction.getIdCompte();
		Compte compteExist ; 
		if((compteExist = compteRepository.findById(compteId).orElse(null)) != null) { 
			compteExist.setSolde(compteExist.getSolde() + transaction.getMontant());
		}
		else { 
			compteExist = new Compte(); 
			compteExist.setIdCompte(transaction.getIdCompte());
			compteExist.setSolde(transaction.getMontant());
			
			compteRepository.save(compteExist);
			
		}
		transaction.setCompte(compteExist);
		return transaction;
	}

}

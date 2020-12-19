package com.architecture_logiciel.tp_spring_batch.batches;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.architecture_logiciel.tp_spring_batch.entities.Compte;
import com.architecture_logiciel.tp_spring_batch.entities.Transaction;

@Component
public class TransactionProcess implements ItemProcessor<Transaction,Transaction>{
	
	@Override
	public Transaction process(Transaction transaction) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); //02/01/2015 23:15 
				
		transaction.setDateTransaction(LocalDateTime.parse(transaction.getDateTransactionString(), formatter));
		transaction.setDateDebit(LocalDateTime.now());
		return transaction;
	}

}

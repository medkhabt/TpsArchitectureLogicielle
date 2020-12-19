package com.architecture_logiciel.tp_spring_batch.batches;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.architecture_logiciel.tp_spring_batch.entities.Transaction;
import com.architecture_logiciel.tp_spring_batch.repositories.TransactionRepository;

@Component
public class TransactionWriter implements ItemWriter<Transaction>{

	@Autowired
	private TransactionRepository transactionRepository ; 
	@Override
	public void write(List<? extends Transaction> items) throws Exception {
		transactionRepository.saveAll(items); 
	}

}

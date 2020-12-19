package com.architecture_logiciel.tp_spring_batch.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.architecture_logiciel.tp_spring_batch.entities.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Integer>{
	
}

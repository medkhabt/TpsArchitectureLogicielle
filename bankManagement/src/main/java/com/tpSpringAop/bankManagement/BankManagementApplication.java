package com.tpSpringAop.bankManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tpSpringAop.bankManagement.entities.Client;
import com.tpSpringAop.bankManagement.entities.Compte;

@SpringBootApplication
public class BankManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
		
	}

}

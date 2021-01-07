package com.tpAspect.entity;

public class Compte {
	private double solde;

	
	public Compte(double solde) {
		super();
		this.solde = solde;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public void debiter (double  mt) {
		solde-=mt;
	}
	
	public void approvisionner (double  mt) {
		solde+=mt;
	}

}
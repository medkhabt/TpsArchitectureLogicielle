package com.tpAspect.entity;

public class Client {

	private String nom;
	private Compte cp;
	
	public Client(String nom, Compte cp) {
		super();
		this.nom = nom;
		this.cp = cp;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Compte getCp() {
		return cp;
	}
	public void setCp(Compte cp) {
		this.cp = cp;
	}
	
	public void retirer(double mt) {
		cp.debiter(mt);
	}
	
	public void verser(double mt) {
		cp.approvisionner(mt);
	}
}
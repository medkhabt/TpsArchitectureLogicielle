package com.architecture_ord.tp.command_desing_pattern.appareil_dom;

public abstract class AppareilDomistique {
	protected String id; 
	protected String name ; 
	protected Boolean working; 
	
	

	public AppareilDomistique(String id, String name) {
		this.id = id;
		this.name = name;
		this.working = false;
	}
	public abstract void turnOn(); 
	public abstract void turnOff(); 
	
	
}

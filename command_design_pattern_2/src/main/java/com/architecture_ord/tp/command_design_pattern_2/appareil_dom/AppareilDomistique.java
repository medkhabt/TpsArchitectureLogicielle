package com.architecture_ord.tp.command_design_pattern_2.appareil_dom;

public abstract class AppareilDomistique {

	protected String name; 
	protected String id; 
	protected Boolean working;
	public AppareilDomistique(String name, String id) {
		this.name = name;
		this.id = id;
		this.working = false;
	} 
	
	
	public abstract void turnOn(); 
	public abstract void turnOff(); 
}

package com.architecture_ord.tp.command_desing_pattern.appareil_dom;

public class Radio extends AppareilDomistique{

	public Radio(String id, String name) {
		super(id, name);
	}

	@Override
	public void turnOn() {
		if(working) {
			System.out.println("Radio: " + this.name + " already turned on!");
		}
		else {
			System.out.println("Radio: " + this.name + " turned on");
			working = true;
		}		
	}

	@Override
	public void turnOff() {
		if(working) {
			System.out.println("Radio: " + this.name + " turned off");
			working = false;
		}
		else {
			System.out.println("Radio: " + this.name + " already turned off!");
		}
	}		

}

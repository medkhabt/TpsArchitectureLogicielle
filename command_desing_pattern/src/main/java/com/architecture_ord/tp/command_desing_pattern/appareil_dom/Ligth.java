package com.architecture_ord.tp.command_desing_pattern.appareil_dom;

public class Ligth extends AppareilDomistique{

	public Ligth(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void turnOn() {
		if(working) {
			System.out.println("Light: " + this.name + " already turned on!");
		}
		else {
			System.out.println("Light: " + this.name + " turned on");
			working = true;
		}
		
	}

	@Override
	public void turnOff() {
		if(working) {
			System.out.println("Light: " + this.name + " turned off");
			working = false;
		}
		else {
			System.out.println("Light: " + this.name + " already turned off!");
		}
	}

}

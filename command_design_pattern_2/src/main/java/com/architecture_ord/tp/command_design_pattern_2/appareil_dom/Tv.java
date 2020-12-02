package com.architecture_ord.tp.command_design_pattern_2.appareil_dom;

public class Tv extends AppareilDomistique{
	public Tv(String id, String name) {
		super(id, name);
	}

	@Override
	public void turnOn() {
		if(working) {
			System.out.println("TV: "+ this.name+" already turned on!");
		}
		else {
			System.out.println("TV: "+ this.name + " turned on");
			working = true;
		}
		 
	}

	@Override
	public void turnOff() {
		if(working) {
			System.out.println("TV: "+ this.name + " turned off");
			working = false;
		}
		else {
			System.out.println("TV: "+ this.name+" already turned off!");
		}
		
		 
	}
}

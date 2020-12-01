package com.architecture_ord.tp.command_desing_pattern.command.impl;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.command.ICommand;

public class LightOnCommand implements ICommand{
	AppareilDomistique light ; 
	

	public LightOnCommand(AppareilDomistique light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
		
	}

	@Override
	public void undo() {
		System.out.print("(undo) ");
		light.turnOff(); 
	}

}

package com.architecture_ord.tp.command_desing_pattern.command.impl;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.command.ICommand;

public class LightOffCommand implements ICommand{

AppareilDomistique light ; 
	

	public LightOffCommand(AppareilDomistique light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
		
	}

	@Override
	public void undo() {
		System.out.print("(undo) ");
		light.turnOn(); 
	}

}

package com.architecture_ord.tp.command_design_pattern_2.command.impl;

import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_design_pattern_2.command.ICommand;

public class LigthOnCommand implements ICommand{
AppareilDomistique light ; 
	

	public LigthOnCommand(AppareilDomistique light) {
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

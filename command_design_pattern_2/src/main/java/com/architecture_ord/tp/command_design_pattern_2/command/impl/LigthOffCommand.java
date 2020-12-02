package com.architecture_ord.tp.command_design_pattern_2.command.impl;

import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_design_pattern_2.command.ICommand;


public class LigthOffCommand implements ICommand{

AppareilDomistique light ; 
	

	public LigthOffCommand(AppareilDomistique light) {
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

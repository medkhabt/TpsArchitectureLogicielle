package com.architecture_ord.tp.command_desing_pattern.command.impl;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.command.ICommand;

public class RadioOnCommand implements ICommand{
	private AppareilDomistique radio;

	public RadioOnCommand(AppareilDomistique radio) {
		this.radio = radio;
	}

	@Override
	public void execute() {
		radio.turnOn();
	}

	@Override
	public void undo() {
		System.out.print("(undo) ");
		radio.turnOff();
	} 
	
	
	
}

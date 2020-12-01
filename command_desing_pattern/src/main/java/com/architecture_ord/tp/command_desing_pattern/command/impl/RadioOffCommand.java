package com.architecture_ord.tp.command_desing_pattern.command.impl;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.command.ICommand;

public class RadioOffCommand implements ICommand{

	private AppareilDomistique radio;

	public RadioOffCommand(AppareilDomistique radio) {
		this.radio = radio;
	}

	@Override
	public void execute() {
		radio.turnOff();
	}

	@Override
	public void undo() {
		System.out.print("(undo) ");
		radio.turnOn();
	} 
}

package com.architecture_ord.tp.command_design_pattern_2.command.impl;

import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_design_pattern_2.command.ICommand;

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

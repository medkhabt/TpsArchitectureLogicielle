package com.architecture_ord.tp.command_desing_pattern.command.impl;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.command.ICommand;

public class TvOnCommand implements ICommand{

	private AppareilDomistique tv; 
	

	public TvOnCommand(AppareilDomistique tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.turnOn();
	}

	@Override
	public void undo() {
		System.out.print("(undo) ");
		tv.turnOff();
	}

}

package com.architecture_ord.tp.command_design_pattern_2.command.impl;

import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_design_pattern_2.command.ICommand;

public class TvOffCommand implements ICommand{
	private AppareilDomistique tv;

	public TvOffCommand(AppareilDomistique tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.turnOff();
	}

	@Override
	public void undo() {
		System.out.print("(undo) ");
		tv.turnOn();
	} 
}

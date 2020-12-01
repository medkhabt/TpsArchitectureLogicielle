package com.architecture_ord.tp.command_desing_pattern.remote_controller;

import java.util.ArrayList;
import java.util.List;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.command.ICommand;

public abstract class RemoteController {
	protected ICommand button;
	protected List<AppareilDomistique> appareils = new ArrayList<>(); 
	
	

	public RemoteController(List<AppareilDomistique> appareils) {
		this.appareils = appareils;
	}
	
	public void setCommand(ICommand command) { 
		this.button = command; 
	}
	public abstract void buttonWasPressed(String buttonPressed);


}

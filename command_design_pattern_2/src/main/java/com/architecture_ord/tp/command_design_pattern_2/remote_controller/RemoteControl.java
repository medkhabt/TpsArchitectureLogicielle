package com.architecture_ord.tp.command_design_pattern_2.remote_controller;

import java.util.HashMap;
import java.util.Map;

import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_design_pattern_2.command.ICommand;

public abstract class RemoteControl {
	protected Map<String, ICommand> commands = new HashMap<>(); 
	public RemoteControl() {
		init(); 
	}
	
	private void init() {
		commands.put("tvOn", null); 
		commands.put("tvOff", null); 
		commands.put("radioOn", null);
		commands.put("radioOff", null);
		commands.put("ligthOn", null);
		commands.put("ligthOff", null); 
		commands.put("undo", null);
		
	}


	public abstract void buttonWasPressed(String commandSlot, ICommand command); 
	public abstract void undoWasPressed(); 
}


//["tv on" -> new TvOnCommand(),]
		
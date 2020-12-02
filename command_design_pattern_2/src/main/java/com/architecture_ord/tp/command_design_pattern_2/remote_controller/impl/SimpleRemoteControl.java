package com.architecture_ord.tp.command_design_pattern_2.remote_controller.impl;

import com.architecture_ord.tp.command_design_pattern_2.command.ICommand;
import com.architecture_ord.tp.command_design_pattern_2.remote_controller.RemoteControl;

public class SimpleRemoteControl extends RemoteControl{

	public SimpleRemoteControl() {
		super();
	}

	@Override
	public void buttonWasPressed(String commandSlot, ICommand command) {
		commands.put(commandSlot, command);
		commands.put("undo", command); //store the last command in undo slot. 
		command.execute();
		System.out.println("\n###################\n");
	}
	
	/**
	 * execute the command stored in undo slot 
	 */
	@Override
	public void undoWasPressed() {
		commands.get("undo").undo();
		System.out.println("\n###################\n");

	}

}

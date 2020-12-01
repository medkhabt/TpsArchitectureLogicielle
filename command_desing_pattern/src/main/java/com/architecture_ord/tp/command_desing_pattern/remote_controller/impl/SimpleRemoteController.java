package com.architecture_ord.tp.command_desing_pattern.remote_controller.impl;

import java.util.List;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.appareil_dom.Ligth;
import com.architecture_ord.tp.command_desing_pattern.appareil_dom.Radio;
import com.architecture_ord.tp.command_desing_pattern.appareil_dom.Tv;
import com.architecture_ord.tp.command_desing_pattern.command.impl.LightOffCommand;
import com.architecture_ord.tp.command_desing_pattern.command.impl.LightOnCommand;
import com.architecture_ord.tp.command_desing_pattern.command.impl.RadioOffCommand;
import com.architecture_ord.tp.command_desing_pattern.command.impl.RadioOnCommand;
import com.architecture_ord.tp.command_desing_pattern.command.impl.TvOffCommand;
import com.architecture_ord.tp.command_desing_pattern.command.impl.TvOnCommand;
import com.architecture_ord.tp.command_desing_pattern.remote_controller.RemoteController;

public class SimpleRemoteController extends RemoteController{


	public SimpleRemoteController(List<AppareilDomistique> appareils) {
		super(appareils);
	}
	/**
	 * we can make it even better, by adding a list of Commands in our ICommand sub classes, so we can execute 
	 * bunch of command in a single execute, but we need a reset tho/or not. 
	 */
	@Override
	public void buttonWasPressed(String buttonPressed) {
		
		if(buttonPressed == "undo")
			button.undo();
		
		for(AppareilDomistique app : appareils) { 
			switch(buttonPressed){ 
			case "onTv": 
				if(app instanceof Tv) {
					button = new TvOnCommand(app);
					button.execute();	
				}
				break;
			case "offTv":
				if( app instanceof Tv) {
					button = new TvOffCommand(app); 
					button.execute();
				}
				break;
			case "onLigth":
				if(app instanceof Ligth) {
					button = new LightOnCommand(app);
					button.execute();
				}
				break;
			case "offLigth":
				if(app instanceof Ligth) {
					button = new LightOffCommand(app);
					button.execute();
				}
				break;
			case "onRadio":
				if(app instanceof Radio) { 
					button = new RadioOnCommand(app); 
					button.execute();
				}
				break;
			case "offRadio":
				if(app instanceof Radio) {
					button = new RadioOffCommand(app); 
					button.execute();
				}
			
			}	
			/**
			 * if we want to undo a single command
			 */
			
			
			/**
			 * we can undo all devices , by checking button class. 
			 */
		}
		
		System.out.println("\n##########################\n");
	}
	

}



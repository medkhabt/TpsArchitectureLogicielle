package com.architecture_ord.tp.command_design_pattern_2;

import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.Ligth;
import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.Radio;
import com.architecture_ord.tp.command_design_pattern_2.appareil_dom.Tv;
import com.architecture_ord.tp.command_design_pattern_2.command.impl.LigthOnCommand;
import com.architecture_ord.tp.command_design_pattern_2.command.impl.RadioOffCommand;
import com.architecture_ord.tp.command_design_pattern_2.command.impl.RadioOnCommand;
import com.architecture_ord.tp.command_design_pattern_2.command.impl.TvOffCommand;
import com.architecture_ord.tp.command_design_pattern_2.command.impl.TvOnCommand;
import com.architecture_ord.tp.command_design_pattern_2.remote_controller.RemoteControl;
import com.architecture_ord.tp.command_design_pattern_2.remote_controller.impl.SimpleRemoteControl;

/**
 *		commands.put("tvOn", null); 
		commands.put("tvOff", null); 
		commands.put("radioOn", null);
		commands.put("radioOff", null);
		commands.put("ligthOn", null);
		commands.put("ligthOff", null); 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RemoteControl srm = new SimpleRemoteControl(); 
    	
    	AppareilDomistique tv = new Tv("asdfa1", "just a tv"); 
    	AppareilDomistique ligth = new Ligth("da2", "light bro"); 
    	AppareilDomistique radio = new Radio("da", "really, radio?"); 
    	
    	srm.buttonWasPressed("tvOn", new TvOnCommand(tv));
    	srm.undoWasPressed();
    	srm.buttonWasPressed("tvOn", new TvOnCommand(tv));
    	
    	srm.buttonWasPressed("ligthOn", new LigthOnCommand(ligth));
    	srm.buttonWasPressed("ligthOn", new LigthOnCommand(ligth));
    	
    	srm.undoWasPressed();
    	
    	/**
    	 * Radio already turned off (initial state) 
    	 */
    	srm.buttonWasPressed("radioOff", new RadioOffCommand(radio));
    	srm.buttonWasPressed("radioOn", new RadioOnCommand(radio));
    	
    	
    }
}

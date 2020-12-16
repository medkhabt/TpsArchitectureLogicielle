package com.architecture_ord.tp.command_desing_pattern;

import java.util.ArrayList;
import java.util.List;

import com.architecture_ord.tp.command_desing_pattern.appareil_dom.AppareilDomistique;
import com.architecture_ord.tp.command_desing_pattern.appareil_dom.Ligth;
import com.architecture_ord.tp.command_desing_pattern.appareil_dom.Radio;
import com.architecture_ord.tp.command_desing_pattern.appareil_dom.Tv;
import com.architecture_ord.tp.command_desing_pattern.remote_controller.RemoteController;
import com.architecture_ord.tp.command_desing_pattern.remote_controller.impl.SimpleRemoteController;

/**
 * we have in issue here, we can put a Light object as an argument for TvOnCommand or RadioOnCommand
 * we can solve this problem by adding sub-interfaces, which define which, interface has control over which objects. 
 * for example we have LightInterface that control all the classes that are related to the lighton and off (like versions_ 
 *
 * 1 slot : tout les devices Tvs.
 * 2 slot : tout les devices Light
 * 3 slot : tout les devices Radio
 * 
 * @author medkhalil
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	List<AppareilDomistique> appareils = new ArrayList<>(); 
    	appareils.add(new Tv("12d", "Samsung Smart")); 
    	appareils.add(new Radio("43v", "Radio SiriusXm")); 
    	appareils.add(new Ligth("41d", "Schneider Electric")); 
    	appareils.add(new Tv("53s", "LG")); 
    	
    	
    	RemoteController src = new SimpleRemoteController(appareils);

    	src.buttonWasPressed("onTv");
    	src.buttonWasPressed("onLigth");
    	src.buttonWasPressed("onTv");
    	src.buttonWasPressed("onRadio");
    	src.buttonWasPressed("offTv");
    	src.buttonWasPressed("undo");


    }
}

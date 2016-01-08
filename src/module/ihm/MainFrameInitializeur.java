/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.action.AbstractIHMAction;
import javax.swing.JButton;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class MainFrameInitializeur extends AbstractIHMAction{

    public MainFrameInitializeur(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
        System.err.println("Main frame initializeur");
        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        PandaProdButton button = (PandaProdButton) application.getMainFrameJComponent("pandaProdButtonNetworkSimulation");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.SimulationNetwork);
        button = (PandaProdButton) application.getMainFrameJComponent("pandaProdButtonFourmis");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.SimulationFourmis);
        button = (PandaProdButton) application.getMainFrameJComponent("pandaProdButtonCastlefight");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.SimulationCastlefight);        
        
        return true;
    }
    
}

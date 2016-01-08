/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.AbstractElement;
import panda.prod.application.PandaProdApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.network.Network;
import model.network.interfaces.AbstractNetworkElement;
import module.backoffice.network.LoadModelNetwork;
import module.backoffice.LoadModelFourmis;
import module.backoffice.network.LaunchSimulation;
import module.backoffice.network.SimulationInProgress;
import module.ihm.FourmisFrameInitializeur;
import module.ihm.network.NetworkFrameInitializeur;
import view.MapPPFrame;
import view.MapPPFrame2;

public class Dispatcher implements ActionListener {

    private static Dispatcher INSTANCE;
    private final PandaProdApplication application;

    private Dispatcher() {
        application = PandaProdApplication.getApplication();
    }

    public static Dispatcher getDispatcher() {
        if (INSTANCE == null) {
            INSTANCE = new Dispatcher();
        }

        return INSTANCE;
    }

    /**
     * Distribue les actions de l'utilsiateur à des traitements
     *
     * @param e Evénement décrivant l'action à réaliser
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionName = e.getActionCommand() + "Action";
        try {
            Method actionToPerform = Dispatcher.class.getDeclaredMethod(actionName);
            actionToPerform.invoke(this);
        } catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, "Unknown action: " + actionName, ex);
        }
    }

    public void simulationNetworkAction() {
        System.err.println("simulation network");
        new LoadModelNetwork().execute();
        application.setMainFrame(new MapPPFrame(10, 10));
        new NetworkFrameInitializeur(application.getMainFrame()).execute();
        new LaunchSimulation().execute();
        
    }

    public void nextStepAction() {
        System.err.println("Next step");
        new SimulationInProgress().execute();

    }

    public void simulationFourmisAction() {
        System.err.println("simulation fourmis");
        new LoadModelFourmis().execute();
        application.setMainFrame(new MapPPFrame(10, 10));
        new FourmisFrameInitializeur(application.getMainFrame()).execute();
    }

}

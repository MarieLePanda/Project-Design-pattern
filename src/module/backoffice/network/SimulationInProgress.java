/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice.network;

import interfaces.AbstractElement;
import interfaces.action.IAction;
import model.network.Network;
import model.network.interfaces.AbstractNetworkElement;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author Lucas
 */
public class SimulationInProgress implements IAction {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Network pl = (Network) application.getMap();
        AbstractElement[][] network = (AbstractElement[][]) pl.getElementMap();

        for (int i = 0; i < network.length; i++) {
            for (int j = 0; j < network[i].length; j++) {
                AbstractNetworkElement networkElement = (AbstractNetworkElement) network[i][j];
                networkElement.processingMessageToSend();
            }
        }
        
        for (int i = 0; i < network.length; i++) {
            for (int j = 0; j < network[i].length; j++) {
                AbstractNetworkElement networkElement = (AbstractNetworkElement) network[i][j];
                networkElement.processingMessageReceive();
            }
        }

        return true;
    }
}

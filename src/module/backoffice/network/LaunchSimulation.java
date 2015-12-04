/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice.network;

import interfaces.AbstractElement;
import interfaces.AbstractNetworkElement;
import interfaces.Plateau;
import interfaces.action.IAction;
import model.network.Message;
import model.network.Network;
import model.network.Server;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author Lucas
 */
public class LaunchSimulation implements IAction {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Network pl = (Network) application.getMap();
        AbstractElement[][] network = (AbstractElement[][]) pl.getElementMap();
        AbstractNetworkElement networkElement = (AbstractNetworkElement) network[0][0];
        networkElement.sendMessage(new Message((Server) networkElement, "Hello panda",(Server) network[8][5]));
        
        return true;
    }

}

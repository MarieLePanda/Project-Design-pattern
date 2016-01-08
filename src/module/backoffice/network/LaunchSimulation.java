/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice.network;

import interfaces.AbstractElement;
import model.network.interfaces.AbstractNetworkElement;
import interfaces.action.IAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.network.Network;
import model.network.Server;
import model.network.mail.Mail;
import model.network.virus.virus;
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
        AbstractNetworkElement networkElement = (AbstractNetworkElement) network[4][0];
        networkElement.sendMessage(new Mail((Server) networkElement, "Hello panda 0", (Server) network[0][0]));
        networkElement.sendMessage(new Mail((Server) networkElement, "Hello panda 1", (Server) network[4][5]));
        networkElement.sendMessage(new Mail((Server) networkElement, "Hello panda 2", (Server) network[9][0]));
        //networkElement.sendMessage(new virus((Server) networkElement, "Hello panda",(Server) network[3][5]));
        networkElement = (AbstractNetworkElement) network[4][5];
        networkElement.sendMessage(new Mail((Server) networkElement, "Hello firefox 0", (Server) network[0][0]));
        networkElement.sendMessage(new Mail((Server) networkElement, "Hello firefox 2", (Server) network[9][0]));

        return true;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm.network;

import interfaces.AbstractElement;
import interfaces.AbstractNetworkElement;
import interfaces.action.AbstractIHMAction;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import javax.swing.JPanel;
import model.network.Network;
import model.network.Server;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class TransfertMessage extends AbstractIHMAction {

    public TransfertMessage(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
        AbstractNetworkElement networkElement = (AbstractNetworkElement) object[0];
        PandaProdApplication application = PandaProdApplication.getApplication();
        Network pl = (Network) application.getMap();
        AbstractElement[][] network = pl.getElementMap();
        JPanel jpanel = (JPanel) application.getMainFrameJComponent("mapJPanel");
        System.err.println(jpanel.getComponents().length);
        
        return true;
    }

}

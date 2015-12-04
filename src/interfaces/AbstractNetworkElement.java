/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.network.Message;
import module.ihm.network.TransfertMessage;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author Lucas
 */
public abstract class AbstractNetworkElement extends AbstractElement {

    public void sendMessage(Message message) {
        if (message.isValid()) {
            for (AbstractElement element : listPath) {
                AbstractNetworkElement networkElement = (AbstractNetworkElement) element;
                networkElement.receiveMessage(message);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    System.err.println("ERREUR THREAD");
                }

            }
        }
    }

    public void receiveMessage(Message message) {
        //System.out.println(this.place.getName());
        place.setBackground(Color.yellow);
        if (message.getTarget().getName().equals(name) && message.isValid()) {
            System.out.println("HEY ! I AM " + name + " I HAVE A MESSAGE !!!! " + message.getContenue());
            place.setBackground(Color.green);
            message.ignoreMessage();
        } else {
            sendMessage(message);
            //this.place.setBackground(Color.gray);
        }
        //new TransfertMessage(PandaProdApplication.getApplication().getMainFrame()).execute(this);
    }
}

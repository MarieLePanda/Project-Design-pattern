/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.interfaces;

import interfaces.AbstractElement;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public abstract class AbstractNetworkElement extends AbstractElement {

    public void sendMessage(Message message) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AbstractNetworkElement.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread t = new Thread() {
            @Override
            public void run() {
                if (message.isValid()) {
                    for (AbstractElement element : listPath) {
                        AbstractNetworkElement networkElement = (AbstractNetworkElement) element;
                        networkElement.receiveMessage(message);
                    }

                }
            
            }
            };
        t.start();
        }

    public void receiveMessage(Message message) {
        //System.out.println(this.place.getName());
        if (message.isValid()) {
            if (message.getTarget().getName().equals(name)) {
                System.out.println("HEY ! I AM " + name + " I HAVE A MESSAGE !!!! " + message.open());
                place.setBackground(Color.green);
            } else {
                place.setBackground(Color.yellow);
                sendMessage(message);
            }
        } else {
            message.ignoreMessage();
        }
    }

}

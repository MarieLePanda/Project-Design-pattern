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
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public abstract class AbstractNetworkElement extends AbstractElement {

    public void sendMessage(Message message) {
        /*Thread t = new Thread() {
         @Override
         public void run() {
         */ if (message.isValid()) {
            for (AbstractElement element : listPath) {
                AbstractNetworkElement networkElement = (AbstractNetworkElement) element;
                networkElement.receiveMessage(message);
            }

        }

        /*}
         };
         t.start();*/
    }

    public void processingMessage() {

        if (!listMessage.isEmpty()) {
            Message message = listMessage.remove(0);
            System.out.println(place.getName());
            if (message.isValid()) {
                if (message.getTarget().getName().equals(name)) {
                    System.err.println(message);
                    System.out.println("HEY ! I AM " + name + " I HAVE A MESSAGE !!!! " + message.open());
                    place.setIcon(new ImageIcon("resources\\reseau\\mail.png"));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AbstractNetworkElement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    place.setIcon(new ImageIcon("resources\\reseau\\mail.png"));

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AbstractNetworkElement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //place.setBackground(null);
                    //place.setIcon(null);
                    sendMessage(message);
                }
            }
        }
    }

}

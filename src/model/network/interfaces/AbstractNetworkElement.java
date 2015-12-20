/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.interfaces;

import interfaces.AbstractElement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public abstract class AbstractNetworkElement extends AbstractElement {

    private ArrayList<Message> listMessageReceive = new ArrayList<>();
    private ArrayList<Message> listMessageToSend = new ArrayList<>();

    public void receiveMessage(Message message) {
        listMessageReceive.add(message);
    }

    public void sendMessage(Message message) {
        listMessageToSend.add(message);

    }

    public void processingMessageReceive() {
        if (!listMessageReceive.isEmpty()) {
            Message message = listMessageReceive.remove(0);
            if (message.isValid()) {

                if (message.getTarget().getName().equals(name)) {
                    System.err.println(message.contenue);
                    System.out.println("HEY ! I AM " + name + " I HAVE A MESSAGE !!!! " + message.open());
                    place.setIcon(new ImageIcon("resources\\reseau\\mail.png"));

                } else {
                    place.setIcon(new ImageIcon("resources\\reseau\\mail.png"));

                            //place.setBackground(null);
                    //place.setIcon(null);
                    sendMessage(message);
                }
            }
        }
    }

    public void processingMessageToSend() {

        for (Message message : listMessageToSend) {
            if (message.isValid()) {
                for (AbstractElement element : listPath) {
                    AbstractNetworkElement networkElement = (AbstractNetworkElement) element;
                    networkElement.receiveMessage(message);
                }
            }
        }
        listMessageToSend.clear();
        place.setIcon(null);
    }

}

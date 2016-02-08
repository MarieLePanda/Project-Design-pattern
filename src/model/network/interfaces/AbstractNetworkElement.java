/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.interfaces;

import interfaces.AbstractElement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.network.utils.dijkstra.Dijkstra;
import model.network.utils.dijkstra.Edge;

/**
 *
 * @author Lucas
 */
public abstract class AbstractNetworkElement extends AbstractElement {

    public ArrayList<Message> listMessageReceive = new ArrayList<>();
    public ArrayList<Message> listMessageToSend = new ArrayList<>();

    public void receiveMessage(Message message) {
        listMessageReceive.add(message);
    }

    public void sendMessage(Message message) {
        listMessageToSend.add(message);

    }

    public void processingMessageReceive() {
        if (!listMessageReceive.isEmpty()) {
            for (Message message : listMessageReceive) {
                if (message.isValid()) {

                    if (message.getTarget().getName().equals(name)) {
                        System.err.println(message.contenue);
                        System.out.println("HEY ! I AM " + name + " I HAVE A MESSAGE !!!! " + message.open());
                        JPanel jp = (JPanel) place.getParent();
                        jp.setBackground(Color.cyan);

                    } else {
                        JPanel jp = (JPanel) place.getParent();
                        jp.setBackground(chooseColor());
                        System.err.println("Je vais renvoyer le message");

                        sendMessage(message);
                    }
                }
            }
            listMessageReceive.clear();
        }
    }

    public void processingMessageToSend() {
        JPanel jp = (JPanel) place.getParent();
        jp.setBackground(chooseColor());
        for (Message message : listMessageToSend) {
//        if (!listMessageToSend.isEmpty()) {
//            Message message = listMessageToSend.get(0);
//            System.err.println("this " + this.getName() + " destinataire : " + message.target.name);
            if (message.isValid()) {
                AbstractElement arrive =  Dijkstra.findeBestWay(this, message.target.getName());
//                System.err.println("arrivé trouvé " + arrive.getName());
                System.err.println("this trouvé " + this.getName());
                System.err.println("Destination message " + message.target.getName());
                System.err.println("arrive " + arrive.getName());
                System.err.println("null ? " + arrive.previous);
                while (arrive.previous != this) {
                    arrive = arrive.previous;
                    System.err.println("previous " + arrive.getName());
                }
                ((AbstractNetworkElement)arrive).receiveMessage(message);
                System.err.println("j'envoie à " + arrive.getName());
            }
//            listMessageToSend.remove(0);
        }
        listMessageToSend.clear();
    }

    

    private Color chooseColor() {
//        System.err.println("taille " + listMessageReceive.size());
        if (listMessageReceive.size() > 10) {
            return Color.red;
        }
        if (listMessageReceive.size() > 2) {
            return Color.orange;
        }
        if (listMessageReceive.size() > 0) {
            return Color.green;
        }

        return null;
    }
}

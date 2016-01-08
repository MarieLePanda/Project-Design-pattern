/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.interfaces;

import interfaces.AbstractElement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.network.Dijkstra;
import model.network.Edge;

/**
 *
 * @author Lucas
 */
public abstract class AbstractNetworkElement extends AbstractElement {

    private double distance = Double.POSITIVE_INFINITY;
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private boolean actif = false;

    public ArrayList<Message> listMessageReceive = new ArrayList<>();
    public ArrayList<Message> listMessageToSend = new ArrayList<>();
    public AbstractNetworkElement previous;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        if (this.distance == Double.POSITIVE_INFINITY) {
            this.distance = 0;
        }
        this.distance += distance;
    }

    public void setEdges(List<Edge> edges) {
        //this.edges = edges;
        this.edges.clear();
    }

    public ArrayList<Edge> getEdge() {
        return edges;
    }

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
                        place.setIcon(new ImageIcon("resources\\reseau\\mail.png"));

                    } else {
                        place.setIcon(new ImageIcon("resources\\reseau\\mail.png"));
                        System.err.println("Je vais renvoyer le message");
                        //place.setBackground(null);
                        //place.setIcon(null);
                        sendMessage(message);
                    }
                }
            }
            listMessageReceive.clear();
        }
    }

    public void processingMessageToSend() {

        for (Message message : listMessageToSend) {
            System.err.println("this " + this.getName() + " destinataire : " + message.target.name);
            if (message.isValid()) {
                AbstractNetworkElement arrive = Dijkstra.findeBestWay(this, message.target.getName());
                System.err.println("arrivé trouvé " + arrive.getName());
                while (arrive.previous != this) {
                    arrive = arrive.previous;
                }
                arrive.receiveMessage(message);
                System.err.println("j'envoie à " + arrive.getName());
            }
        }
        listMessageToSend.clear();
        place.setIcon(null);
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}

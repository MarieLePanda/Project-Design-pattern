/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;

import java.util.ArrayList;
import model.network.interfaces.AbstractNetworkElement;

/**
 *
 * @author Lucas
 */
public class Edge {

    private AbstractNetworkElement elementOne, elementTwo;
    private Distance value;
    private ArrayList<Edge> pile = new ArrayList<Edge>();

    public Edge(AbstractNetworkElement elementOne, AbstractNetworkElement elementTwo, Distance value) {
        // TODO Auto-generated constructor stub
        this.elementOne = elementOne;
        this.elementTwo = elementTwo;
        this.value = value;
        this.elementOne.getEdge().add(this);
        this.elementTwo.getEdge().add(this);
    }

    public Distance getAttribute() {
        // TODO Auto-generated method stub
        return value;
    }

    public AbstractNetworkElement getOther(AbstractNetworkElement node) {
        // TODO Auto-generated method stub
        if (node == elementOne) {
            return elementTwo;
        } else if (node == elementTwo) {
            return elementOne;
        } else {
            return null;
        }

    }

    public void setAttribute(int Distance) {
        // TODO Auto-generated method stub
        value.addValue(Distance);
    }

    public void push(Edge e) {
        pile.add(e);
    }

    public ArrayList<Edge> getPile() {
        return pile;
    }
}

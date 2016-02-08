/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.utils.dijkstra;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import model.network.Network;
import model.network.interfaces.AbstractNetworkElement;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author Mary
 */
public class Dijkstra {

    /**
     * Enable find the shorter way at T instant
     *
     * @param start Start node
     * @return next node to take the shorter way.
     */
    public static AbstractNetworkElement findeBestWay(AbstractNetworkElement start, String target) {
//        System.err.println("Durée de Dijkstra début : " + new Date(System.currentTimeMillis()).getTime());
        AbstractNetworkElement res = null, current;
        @SuppressWarnings("Convert2Diamond")
        HashMap<Edge, AbstractNetworkElement> log;
        log = new HashMap<Edge, AbstractNetworkElement>();
        current = start;
        current.setDistance(0);
        PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
        while (res == null) {
            AbstractNetworkElement other;
            for (Edge edge : (List<Edge>) current.getEdge()) {
                edge.setAttribute((int) current.getDistance());
                queue.push(new Element(edge));
                log.put(edge, current);
            }
            if (queue.size() == 0) {
                res = current;
            }

            Edge temp = (Edge) queue.pop().getValue();
            while ((other = temp.getOther(current)) == null) {

                current = log.get(temp);
            }
            
            System.err.println("Other Distance : " + other.getName() + " " + other.getDistance() + " Current Distance : " + current.getName() + " " + (current.getDistance() + temp.getAttribute().getValue()));
            if (other.getDistance() > (current.getDistance() + temp.getAttribute().getValue())) {
                System.err.println("Panda passe");
                if (other.isActif() == false) {
                    System.err.println("Panda passe2 other : " + other.getName() + " current : " + current.getName());
                    other.setDistance(temp.getAttribute().getValue() + current.getDistance());
                    other.previous = current;
                }
            }
//            System.err.println("Depart : " + current.getName());
//            for(Edge e : current.getEdge()){
//                System.err.println(e);
//            }
            current.getEdge().remove(temp);
            current = temp.getOther(current);
            current.getEdge().remove(temp);

            if (current.getName().equals(target)) {
//                System.err.println("current " + current.getName());
                res = current;
            }
        }

        Network network = (Network) PandaProdApplication.getApplication().getMap();

        network.createConnectNetwork();
//        System.err.println("Durée de Dijkstra fin : " + new Date(System.currentTimeMillis()).getTime());
        return res;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;


import java.util.HashMap;
import java.util.List;
import model.network.interfaces.AbstractNetworkElement;

/**
 *
 * @author Mary
 */
public class Dijkstra {


    /**
     * Enable find the shorter way at T instant
     * @param start Start node
     * @return next node to take the shorter way.
     */
    public static AbstractNetworkElement findeBestWay(AbstractNetworkElement start, String target) {
	@SuppressWarnings("Convert2Diamond")
	HashMap<Edge, AbstractNetworkElement> log;
	log = new HashMap<Edge, AbstractNetworkElement>();
	AbstractNetworkElement res = null, other, current = start;
	current.setDistance(0);
	PriorityQueue queue = new PriorityQueue(new ComparatorDistance());
        while (res == null) {
	    for (Edge edge : (List<Edge>) current.getEdge()) {
		edge.setAttribute((int) current.getDistance());
                queue.push(new Element(edge));
		log.put(edge, current);
	    }
            if(queue.size() == 0)
                return current;
            
            Edge temp = (Edge) queue.pop().getValue();
	    while ((other = temp.getOther(current)) == null) {

		current = log.get(temp);
	    }

	    if (other.getDistance() > (current.getDistance() + temp.getAttribute().getValue())) {
		if (other.isActif() == false) {
		    other.setDistance(temp.getAttribute().getValue() + current.getDistance());
		    other.previous = current;
		}
	    }
	    current.getEdge().remove(temp);
	    current = temp.getOther(current);
	    current.getEdge().remove(temp);
	    if (current.getName().equals(target)) {
		res = current;
	    }
	}
	return res;
    }

}

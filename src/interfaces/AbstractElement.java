/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.network.interfaces.AbstractNetworkElement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import model.network.interfaces.Message;
import model.network.utils.dijkstra.Edge;


public abstract class AbstractElement {
    
    // Elements adjacents de la case courante.
    protected ArrayList<AbstractElement> listPath = new ArrayList<AbstractElement>();
    
    // Nom de la case
    protected String name;
    // Skin de la case
    protected JLabel place;
    // Distance de la case par rapport à une autre
    private double distance = Double.POSITIVE_INFINITY;
    // Listes de tous les Ponts entre deux cases
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    // ? 
    private boolean actif = false;
    // Prédécesseur de la case courante
    public AbstractElement previous;

    
    /**
     * 
     * GETTERS & SETTERS
     */
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
    
    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<AbstractElement> getListPath() {
        return listPath;
    }
    
    public void addPath(AbstractElement path) {
        listPath.add(path);
    }

    public void removePath(AbstractNetworkElement path) {
        listPath.remove(path);
    }

    public JLabel getPlace() {
        return place;
    }

    public void setPlace(JLabel place) {
        this.place = place;
    }

}

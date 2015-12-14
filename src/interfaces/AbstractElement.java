/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.network.interfaces.AbstractNetworkElement;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Lucas
 */
public abstract class AbstractElement {

    protected ArrayList<AbstractElement> listPath = new ArrayList<AbstractElement>();
    protected String name;
    protected JComponent place;

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

    public JComponent getPlace() {
        return place;
    }

    public void setPlace(JComponent place) {
        this.place = place;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public abstract class AbstractElement {

    protected ArrayList<AbstractElement> listPath = new ArrayList<AbstractElement>();
    protected String name;

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
}

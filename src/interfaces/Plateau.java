/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Lucas
 */
public abstract class Plateau {
    
    protected AbstractElement[][] elementMap;

    public AbstractElement[][] getElementMap() {
        return elementMap;
    }

    public void setElementkMap(AbstractElement[][] elementMap) {
        this.elementMap = elementMap;
    }

    public Plateau() {
        this.elementMap = new AbstractElement[10][10];
    }
    
    public abstract void loadMap();
}

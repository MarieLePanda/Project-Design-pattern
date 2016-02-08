/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.towerdefense;

import interfaces.AbstractElement;

/**
 *
 * @author iklarman
 */
public class Link {
    private AbstractElement elementOne,elementTwo;
    
    public Link(AbstractElement currElement,AbstractElement elementAfter){
       this.elementOne = currElement;
       this.elementTwo = elementAfter;
        
    }
    public AbstractElement getElementOne() {
        return elementOne;
    }

    public void setElementOne(AbstractElement elementOne) {
        this.elementOne = elementOne;
    }

    public AbstractElement getElementTwo() {
        return elementTwo;
    }

    public void setElementTwo(AbstractElement elementTwo) {
        this.elementTwo = elementTwo;
    }
 
    
}

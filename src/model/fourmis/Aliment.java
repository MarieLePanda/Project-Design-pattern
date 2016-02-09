/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.fourmis;

import interfaces.AbstractElement;

/**
 *
 * @author Damien
 */
public class Aliment extends AbstractElementFourmi{
    
    private int parts;
    
    public Aliment(String n){
        this.name=n;
        this.parts=10;
    }
    
    public int getPart(){
        return this.parts;
    }
    
    public void prendrePart(){
        this.parts--;
    }

}

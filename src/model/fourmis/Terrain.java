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
public class Terrain extends AbstractElement{
    
   private Aliment aliment;
   private Pheromone pheromone;
    
    public Terrain(String n){
        this.name=n;
        this.pheromone=null;
        this.aliment=null;
    }
    
    
    public AjouterAliment(){
        this.aliment=new Aliment("Aliment");
    }
    
    public boolean aAliment()
}

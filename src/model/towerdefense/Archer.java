/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.towerdefense;

import interfaces.AbstractElement;
import model.towerdefense.Strategy.MarcherAPied;
import model.towerdefense.interfaces.PersonnageInterface;

/**
 *
 * @author iklarman
 */
public class Archer extends PersonnageAbstractElement{
       
    public Archer(){
       name = "Archer";
       System.out.println("Un Archer créé.");
       setDeplacementStrategy(new MarcherAPied());
        
    }
    
    
}

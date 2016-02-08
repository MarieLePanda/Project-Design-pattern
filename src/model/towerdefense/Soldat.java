/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.towerdefense;

import interfaces.AbstractElement;
import model.towerdefense.interfaces.PersonnageInterface;
import model.towerdefense.Strategy.DeplacementStrategy;
import model.towerdefense.Strategy.MarcherAPied;
/**
 *
 * @author iklarman
 */
public class Soldat extends PersonnageAbstractElement{
    
    public Soldat(){
        name = "SOLDAT";
        System.out.println("Un Soldat créé.");
        setDeplacementStrategy(new MarcherAPied());
    }
  
}

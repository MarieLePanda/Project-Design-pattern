/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.towerdefense;

import interfaces.AbstractElement;
import model.towerdefense.Strategy.AvanceACheval;
import model.towerdefense.Strategy.MarcherAPied;
import model.towerdefense.interfaces.PersonnageInterface;

/**
 *
 * @author iklarman
 */
public class Chevalier extends PersonnageAbstractElement{
    
    public Chevalier(){
        System.out.println("Un Chevalier créé.");
        setDeplacementStrategy(new AvanceACheval());
    }
    
    
}

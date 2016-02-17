/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Plateau;
import model.network.Network;

/**
 *
 * @author Lucas
 */
public class FactoryPlateau {
    
    private FactoryPlateau() {
    }
    
    public static FactoryPlateau getInstance() {
        return FactoryPlateauHolder.INSTANCE;
    }
    
    private static class FactoryPlateauHolder {

        private static final FactoryPlateau INSTANCE = new FactoryPlateau();
    }
    
    public Plateau getNetwork(){
        return new Network();
    }
    
    public Plateau getCastlefight(){
        return new Castlefight();
    }
}

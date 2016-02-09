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
public class Fourmi extends AbstractElement{
    
    private Tunnel origine;
    private Terrain localisation;
    private boolean porteAliment;
    
    public Fourmi(String n, Tunnel t){
        this.name=n;
        this.origine=t;
    }
    
    public void porteAliment(){
        this.porteAliment=true;
    }
    
    public void chercheAliment(){
        if(localisation.){
            
        }
    }
}

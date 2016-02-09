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
public class Tunnel extends AbstractElement {
    
    private int abs;
    private int ord;
    
    public Tunnel(String n, int a, int o){
        this.name=n;
        this.abs=a;
        this.ord=o;
    }
    
    public int getAbscisse(){
        return abs;
    }
    
    public int getOrdonnee(){
        return ord;
    }
}

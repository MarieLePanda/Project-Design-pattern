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
public class Pheromone extends AbstractElementFourmi{
    private Terrain vientDe;
    private int concentration;
    
    public Pheromone(String n, Terrain vientDe){
        this.name=n;
        this.vientDe=vientDe;
        this.concentration=20;
    }
    
    
    
    public Terrain getVientDe(){
        return this.vientDe;
    }
    
    public void attenuer(){
        this.concentration--;
    }
    
    public int getCocentration(){
        return this.concentration;
    }
}

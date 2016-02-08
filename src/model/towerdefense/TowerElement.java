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
public class TowerElement extends Case{
    private int pointAttaque;
    private int vision;
    private int niveau;

    public TowerElement(int x, int y) {
        super(x, y);
        // Défini le nom de la case
        name = "TOURELLE{"+x+y+"}";
    }
     
    public int getPointAttaque() {
        return pointAttaque;
    }

    public void setPointAttaque(int pointAttaque) {
        this.pointAttaque = pointAttaque;
    }

    public int getVision() {
        return vision;
    }
    
    public void setVision(int vision) {
        this.vision = vision;
    }
    public void monterNiveau(){
        this.niveau +=1;
        if(niveau%2 == 0){
            this.vision +=1;
        }
        this.pointAttaque += 10;
    }
}

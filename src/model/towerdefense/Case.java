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
public class Case extends AbstractElement{
    
    private int positionX;
    private int positionY;
    
    public Case(int x,int y){
        this.positionX = x;
        this.positionY = y;
    }
    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}

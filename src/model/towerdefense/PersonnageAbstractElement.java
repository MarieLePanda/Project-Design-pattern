/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.towerdefense;

import interfaces.AbstractElement;
import model.towerdefense.Strategy.DeplacementStrategy;
import model.towerdefense.interfaces.PersonnageInterface;

/**
 *
 * @author iklarman
 */
public abstract class PersonnageAbstractElement extends AbstractElement implements PersonnageInterface{
    private int pointdevie;
    private int nbdepas;
    private boolean reussir;
    
    public DeplacementStrategy deplacement;
    public void setDeplacementStrategy(DeplacementStrategy _dp){
        this.deplacement = _dp;
    }
    
    public int getPointdevie() {
        return pointdevie;
    }
    public void setPointdevie(int pointdevie) {
        this.pointdevie = pointdevie;
    }

    public int getNbdepas() {
        return nbdepas;
    }

    public void setNbdepas(int nbdepas) {
        this.nbdepas = nbdepas;
    }

    public boolean isReussir() {
        return reussir;
    }

    public void setReussir(boolean reussir) {
        this.reussir = reussir;
    }
    
    @Override
    public void avance(){
        deplacement.sedeplacer();
    }
}

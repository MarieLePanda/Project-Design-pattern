/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.towerdefense;


/**
 *
 * @author iklarman
 */
public class SpecialCase extends Case{
    
    public SpecialCase(int x, int y) {
        super(x, y);
        // Défini le nom de la case
        name = "SC{"+x+y+"}";
        System.out.println("Je suis une case spéciale.");
    }
    
}

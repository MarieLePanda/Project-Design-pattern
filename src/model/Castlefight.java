/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.AbstractElement;
import interfaces.Plateau;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.towerdefense.Case;
import model.towerdefense.ParcelleDeTerrain;
import model.towerdefense.SpecialCase;
import model.towerdefense.TowerElement;
import panda.prod.application.SystemSettings;

/**
 *
 * @author iklarman
 */
public class Castlefight extends Plateau{
    
    private int countLine;

    public int getCountLine() {
        return countLine;
    }

    public void setCountLine(int countLine) {
        this.countLine = countLine;
    }
    @Override
    public void loadMap() {
        
        
        try {
            BufferedReader file = new BufferedReader(new FileReader(
                    "src" + SystemSettings.SEPARATOR
                    + "conf" + SystemSettings.SEPARATOR
                    + "mapServer.txt"
            ));
            String line;
            int l = 0;
            
            
            
            // Traitement
            while ((line = file.readLine()) != null) {
                this.countLine = line.length();
                // Random emplacements tourelles
                int[] listRandomCol= {0,0,0},listRandomRow = {0,0,0};
                Random rand = new Random();
                for(int i=0;i<3;i++){
                    listRandomCol[i] = rand.nextInt(this.countLine - 2 + 1) + 1;
                    listRandomRow[i] = rand.nextInt(this.countLine - 2 + 1) + 1;
                    if(listRandomRow[i] == this.countLine || listRandomCol[i] == this.countLine){
                       i -= 1;
                    }
                }
                for (int c = 0; c < line.length(); c++) {
                    if((l != 0 && c != line.length()-1) || (l !=  line.length()-1 && c != 0)){
                        // Départ ou arrivée
                        elementMap[l][c] = new ParcelleDeTerrain(l,c);
                    }else{
                        elementMap[l][c] = new SpecialCase(l,c);
                    }
                    
                    for(int z = 0; z <listRandomCol.length;z++){
                        if(l == listRandomCol[z] && c == listRandomRow[z]){
                            // C'est un emplacement Tourelle
                            elementMap[l][c] = new TowerElement(l,c);
                        }
                    }  
                }
                l++;
            }
            file.close();
        } catch (IOException e) {
            Logger.getLogger("FileIO").log(Level.SEVERE, "Erreur lors de la lecture du fichier de map serveur", e);
        }
        
        
    }
}

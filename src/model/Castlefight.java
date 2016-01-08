/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.AbstractElement;
import interfaces.Plateau;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import panda.prod.application.SystemSettings;

/**
 *
 * @author iklarman
 */
public class Castlefight extends Plateau{

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
                
            while ((line = file.readLine()) != null) {
                for (int c = 0; c < line.length(); c++) {
                   if(c == 0 || c == line.length()-1){
                       elementMap[l][c] = new Terrain("XXX");
                    }
                   elementMap[l][c] = new Terrain("");
                   
                }
                l++;
            }
            file.close();
        } catch (IOException e) {
            Logger.getLogger("FileIO").log(Level.SEVERE, "Erreur lors de la lecture du fichier de map serveur", e);
        }
        
       
    }
}

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
import model.network.Link;
import model.network.Server;
import panda.prod.application.SystemSettings;

/**
 *
 * @author Lucas
 */
public class Network extends Plateau{

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
                    if (line.charAt(c) == 'S') {
                        elementMap[l][c] = new Server("CIS" + Integer.toString(l) + Integer.toString(c));
                    } else {
                        elementMap[l][c] = new Link("Link" + Integer.toString(l) + Integer.toString(c));
                    }

                }
                l++;
            }
            file.close();
        } catch (IOException e) {
            Logger.getLogger("FileIO").log(Level.SEVERE, "Erreur lors de la lecture du fichier de map serveur", e);
        }
        
        createConnectNetwork();
    }
    
    public void createConnectNetwork(){
        AbstractElement current;
        for(int i = 0; i < elementMap.length; i++){
            for(int j = 0; j < elementMap[i].length; j++){
                current = elementMap[i][j];
                if(i < 9){
                    if(j < elementMap[i].length-1){
                        current.addPath( elementMap[i][j+1]);
                    }
                    current.addPath(elementMap[i+1][j]);
                    
                }else{
                    if(j < elementMap[i].length-1){
                        current.addPath(elementMap[i][j+1]);
                    }
                }
            }
        }
    }
}

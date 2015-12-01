/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.AbstractNetworkElement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import panda.prod.application.SystemSettings;

/**
 *
 * @author Lucas
 */
public class Network {

    private AbstractNetworkElement[][] networkMap = new AbstractNetworkElement[10][10];

    public AbstractNetworkElement[][] getNetworkMap() {
        return networkMap;
    }

    public void setNetworkMap(AbstractNetworkElement[][] networkMap) {
        this.networkMap = networkMap;
    }

    public void loadNetworkMap() {
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
                        networkMap[l][c] = new Server("CIS" + Integer.toString(l) + Integer.toString(c));
                    } else {
                        networkMap[l][c] = new Link("Link" + Integer.toString(l) + Integer.toString(c));
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
        AbstractNetworkElement current;
        for(int i = 0; i < networkMap.length; i++){
            for(int j = 0; j < networkMap[i].length; j++){
                current = networkMap[i][j];
                if(i < 9){
                    if(j < networkMap[i].length-1){
                        current.addPath(networkMap[i][j+1]);
                    }
                    current.addPath(networkMap[i+1][j]);
                    
                }else{
                    if(j < networkMap[i].length-1){
                        current.addPath(networkMap[i][j+1]);
                    }
                    
                }
            }
        }
    }
}

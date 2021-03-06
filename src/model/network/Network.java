/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;

import model.network.utils.dijkstra.Edge;
import model.network.utils.dijkstra.Distance;
import interfaces.AbstractElement;
import interfaces.Plateau;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.network.interfaces.AbstractNetworkElement;
import model.network.interfaces.Message;
import panda.prod.application.SystemSettings;

/**
 *
 * @author Lucas
 */
public class Network extends Plateau {

    private ArrayList<AbstractNetworkElement> listOfServers = new ArrayList<AbstractNetworkElement>();
    private ArrayList<Message> listOfMessage = new ArrayList<Message>();

    public ArrayList<Message> getListOfMessage() {
        return listOfMessage;
    }

    public void setListOfMessage(ArrayList<Message> listOfMessage) {
        this.listOfMessage = listOfMessage;
    }
    
    public ArrayList<AbstractNetworkElement> getListOfServers() {
        return listOfServers;
    }

    public void setListOfServers(ArrayList<AbstractNetworkElement> listOfServers) {
        this.listOfServers = listOfServers;
    }
    
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
                        listOfServers.add((AbstractNetworkElement) elementMap[l][c]);
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

    public void createConnectNetwork() {
        System.err.println("create connect");
        for (int i = 0; i < elementMap.length; i++) {
            for (int j = 0; j < elementMap[i].length; j++) {
//                ((AbstractNetworkElement) elementMap[i][j]).previous = null;
                if (i == 0) {
                    if (j == 0) {
                        new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j + 1], new Distance(1));
                        new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i + 1][j], new Distance(1));
                        //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                    } else {
                        if (j < elementMap[i].length - 1) {
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j + 1], new Distance(1));
                            //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                        }
                        new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i + 1][j], new Distance(1));
                        new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j - 1], new Distance(1));
                        //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                    }
                } else {
                    if (i == elementMap.length - 1) {
                        if (j == 0) {
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j + 1], new Distance(1));
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i - 1][j], new Distance(1));
                            //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                        } else {
                            if (j < elementMap[i].length - 1) {
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j + 1], new Distance(1));
                                //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                            }
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j - 1], new Distance(1));
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i - 1][j], new Distance(1));
                            //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                        }
                    } else {

                        if (j == 0) {
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j + 1], new Distance(1));
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i + 1][j], new Distance(1));
                            new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i - 1][j], new Distance(1));
                            //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                        } else {
                            if (j == elementMap[i].length - 1) {
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j - 1], new Distance(1));
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i + 1][j], new Distance(1));
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i - 1][j], new Distance(1));
                                //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());
                            } else {
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j + 1], new Distance(1));
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i][j - 1], new Distance(1));
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i + 1][j], new Distance(1));
                                new Edge((AbstractNetworkElement) elementMap[i][j], (AbstractNetworkElement) elementMap[i - 1][j], new Distance(1));
                                //System.err.println("createConnectNetwork : " + elementMap[i][j].getName());

                            }
                        }
                    }
                }
            }
        }

    }
}

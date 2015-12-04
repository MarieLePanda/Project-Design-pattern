/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;

import interfaces.AbstractElement;
import interfaces.AbstractNetworkElement;

/**
 *
 * @author Lucas
 */
public class Server extends AbstractNetworkElement{
    
    private String message;
    
    public Server(String name){
        this.name = name;
    }
    
    public void sendMessage(String message, String nomeTarget){
        for(AbstractElement element : listPath){
            AbstractNetworkElement networkElement = (AbstractNetworkElement) element;
            networkElement.receiveMessage(message, nomeTarget);
        }
    }
    
    public void receiveMessage(String message, String nomTarget){
        if(nomTarget.equals(name)){
            System.out.println("I HAVE A MESSAGE !!!! " + message);
        }else{
            sendMessage(message, nomTarget);
        }
    }
}

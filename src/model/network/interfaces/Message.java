/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.interfaces;

import model.network.Server;

/**
 *
 * @author Lucas
 */
public abstract class Message {

    protected Server target, starter; 
    protected String contenue;
    protected boolean valid;
    protected Open open;
    
    public String open(){
        return open.open();
    }
    
    public Server getTarget() {
        return target;
    }

    public void setTarget(Server target) {
        this.target = target;
    }

    public Server getStarter() {
        return starter;
    }

    public void setStarter(Server starter) {
        this.starter = starter;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }
   
    
    public Message(Server starter, String contenue, Server target){
        this.starter = starter;
        this.contenue = contenue;
        this.target = target;
        this.valid = true;
    }

    public boolean isValid() {
        return valid;
    }
    
    public void ignoreMessage(){
        valid = false;
    }
}

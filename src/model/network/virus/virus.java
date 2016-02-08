/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.virus;

import model.network.Server;
import model.network.interfaces.Message;

/**
 *
 * @author Lucas
 */
public class virus extends Message{

    public virus(Server starter, String contenue, Server target) {
        super(starter, contenue, target);
        open = new OpenVirus();
    }    
    
    @Override
    public String open(){
        valid = true;
        return open.open();
    }
}

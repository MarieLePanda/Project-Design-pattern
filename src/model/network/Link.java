/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;

import model.network.interfaces.AbstractNetworkElement;

/**
 *
 * @author Lucas
 */
public class Link extends AbstractNetworkElement{
        
    public Link(String name){
        this.name = name;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;

import interfaces.AbstractNetworkElement;

/**
 *
 * @author Lucas
 */
public class Server extends AbstractNetworkElement {

    private String message;

    public Server(String name) {
        this.name = name;
    }
}

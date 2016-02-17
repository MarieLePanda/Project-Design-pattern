/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network;

/**
 *
 * @author Lucas
 */
public class FactoryNetworkElement {
    
    private FactoryNetworkElement() {
    }
    
    public static FactoryNetworkElement getInstance() {
        return FactoryNetworkElementHolder.INSTANCE;
    }
    
    private static class FactoryNetworkElementHolder {

        private static final FactoryNetworkElement INSTANCE = new FactoryNetworkElement();
    }
    
    public Link getLink(String s){
        return new Link(s);
    }
    
    public Server getServer(String s){
        return new Server(s);
    }
}

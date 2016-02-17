/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice.network;

import interfaces.action.IAction;
import model.FactoryPlateau;
import model.network.Network;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author Lucas
 */
public class LoadModelNetwork implements IAction {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        application.setMap(FactoryPlateau.getInstance().getNetwork());
        application.getMap().loadMap();
        /*AbstractNetworkElement [][] network = application.getMap().getNetworkMap();
        for(int i = 0; i < network.length; i++){
            for(int j = 0; j < network[i].length; j++){
                System.err.print(network[i][j].getName() + " ");
            }
            System.err.println("\n");
        }
        
        System.out.println(" CIBLE  : " + network[5][5].getName() + "\n link");
        for(AbstractNetworkElement e : network[5][5].getListPath()){
            System.out.println(e.getName());
        }*/
        
        return true;

    }

}

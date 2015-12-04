/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import interfaces.AbstractElement;
import interfaces.action.AbstractIHMAction;
import interfaces.AbstractNetworkElement;
import interfaces.Plateau;
import java.awt.Color;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.network.Server;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class NetworkFrameInitializeur extends AbstractIHMAction {

    public NetworkFrameInitializeur(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
        System.err.println("Network frame initializeur");
        PandaProdApplication application = PandaProdApplication.getApplication();
        Plateau pl = application.getMap();
        AbstractElement[][] network = pl.getElementMap();
       
        JPanel jpanel = (JPanel) application.getMainFrameJComponent("mapJPanel");
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        Label label;
        for (int i = 0; i < network.length; i++) {
            for (int j = 0; j < network[i].length; j++) {
                AbstractElement element = network[i][j];
                label = new Label(element.getName());
                JPanel ptest = new JPanel();
                if (element instanceof Server) {
                    ptest.setBackground(Color.red);
                }
                ptest.setBorder(blackline);
                ptest.add(label);
                jpanel.add(ptest);
            }
        }

        application.getMainFrame().refresh();
        return true;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import interfaces.AbstractIHMAction;
import interfaces.AbstractNetworkElement;
import java.awt.Color;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Server;
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
        AbstractNetworkElement[][] network = application.getMap().getNetworkMap();
        JPanel jpanel = (JPanel) application.getMainFrameJComponent("mapJPanel");
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        Label label;
        for (int i = 0; i < network.length; i++) {
            for (int j = 0; j < network[i].length; j++) {
                AbstractNetworkElement element = network[i][j];
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

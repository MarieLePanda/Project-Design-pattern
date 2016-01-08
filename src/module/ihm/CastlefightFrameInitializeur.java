/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import interfaces.AbstractElement;
import interfaces.Plateau;
import interfaces.action.AbstractIHMAction;
import java.awt.Color;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Terrain;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdFrame;

/**
 *
 * @author iklarman
 */
public class CastlefightFrameInitializeur extends AbstractIHMAction {

    public CastlefightFrameInitializeur(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
       System.err.println("Castle frame initializeur");
        PandaProdApplication application = PandaProdApplication.getApplication();
        Plateau pl = application.getMap();
        AbstractElement[][] grille = pl.getElementMap();
       
        JPanel jpanel = (JPanel) application.getMainFrameJComponent("mapJPanel");
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        Border route = BorderFactory.createLineBorder(Color.ORANGE, 1);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        Label label;
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                AbstractElement element = grille[i][j];
                //AbstractElement elementACote = grille[i][j+1];
                element.setName("X");
                label = new Label(element.getName());
                JPanel ptest = new JPanel();
                if(i == 0 || i == grille.length-1){
                       ptest.setBackground(Color.GREEN);
                       ptest.setBorder(border);
                }else if(j%4 == 1){
                    ptest.setBackground(Color.ORANGE);
                    ptest.setBorder(route);
                }else if(element instanceof Terrain) {
                    ptest.setBackground(Color.cyan);
                    ptest.setBorder(blackline);
                }
                
               
                ptest.add(label);
                jpanel.add(ptest);
            }
        }

        application.getMainFrame().refresh();
        return true;
    }
    
}

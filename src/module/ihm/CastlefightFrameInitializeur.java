/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import interfaces.AbstractElement;
import interfaces.Plateau;
import interfaces.action.AbstractIHMAction;
import java.awt.Color;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.towerdefense.Case;
import model.towerdefense.Chevalier;
import model.towerdefense.Link;
import model.towerdefense.ParcelleDeTerrain;
import model.towerdefense.PersonnageAbstractElement;
import model.towerdefense.Soldat;
import model.towerdefense.SpecialCase;
import model.towerdefense.Strategy.MarcherAPied;
import model.towerdefense.TowerElement;
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
        
        
        Soldat soldat = new Soldat();
        soldat.avance();
        
        Chevalier chevalier = new Chevalier();
        chevalier.avance();
        
        int[] listRandomCol= {0,0,0},listRandomRow = {0,0,0};
        Random rand = new Random();
        for(int i=0;i<3;i++){
            listRandomCol[i] = rand.nextInt(grille.length - 2 + 1) + 1;
            listRandomRow[i] = rand.nextInt(grille.length - 2 + 1) + 1;
            if(listRandomRow[i] == grille.length || listRandomCol[i] == grille.length){
               i -= 1;
            }
        }
        for (int i = 0; i < grille.length; i++) {  
            for (int j = 0; j < grille[i].length; j++) {
                AbstractElement element = grille[i][j];
                //System.out.println(element);
                label = new Label();
                JPanel ptest = new JPanel();
               if(element instanceof SpecialCase){
                    System.out.println("CECI EST UNE CASE : SPECIALE !");
                    element = (SpecialCase)grille[i][j];
                    if(i == 0){
                        element.setName("S");
                    }else{
                        element.setName("A");
                    }
                    label.setText(element.getName());
                    ptest.setBackground(Color.WHITE);
                    ptest.setBorder(border);
                }else if(element instanceof ParcelleDeTerrain){
                    System.out.println("CECI EST UNE CASE : PARCELLE DE TERRAIN !");
                    element = (ParcelleDeTerrain)grille[i][j];
                    element.setName("P");
                    label.setText(element.getName());
                    ptest.setBackground(Color.LIGHT_GRAY);
                    ptest.setBorder(border);
                }else if(element instanceof TowerElement){
                    System.out.println("CECI EST UNE CASE : TOURELLE !");
                    element = (TowerElement)grille[i][j];
                    element.setName("T");
                    label.setText(element.getName());
                    ptest.setBackground(Color.RED);
                    ptest.setBorder(border);
                }
                ptest.add(label);
                jpanel.add(ptest);              
                /*for(int z = 0; z <listRandomCol.length;z++){
                    if(i == listRandomCol[z] && j == listRandomRow[z]){
                      //  generateTower(element,label,ptest,border);
                    }
                } */         
                
            }
        }
        
        application.getMainFrame().refresh();
        return true;
    }
    void generateTower(AbstractElement element, Label label, JPanel ptest, Border border){
        //element.setName("T");
        label.setText(element.getName());
        ptest.setBackground(Color.RED);
        ptest.setBorder(border);
    }
    void genererChemin(AbstractElement[][] grille, AbstractElement element, Label label, JPanel ptest, Border border){
        for (int i = 0; i < grille.length; i++) {  
            for (int j = 0; j < grille[i].length; j++) {
                if((i != 0 && j != grille.length-1) || (i != grille.length-1 && j != 0)){
                    Link l = new Link(new ParcelleDeTerrain(i,j),new ParcelleDeTerrain(i,j+1));
                    //chemin.add(new ParcelleDeTerrain(i,j));
                    // element.setName("R");
                    label.setText(element.getName());
                    ptest.setBackground(Color.ORANGE);
                    ptest.setBorder(border);
                    
                }else{
                        System.out.println("Case spéciale -> Coordonnée X = "+i+" Y = "+j);
                }
            }
        }
    }
    
}

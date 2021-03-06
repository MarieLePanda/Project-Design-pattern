/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class MapPPFrame extends PandaProdFrame {

    private JPanel mapJPanel;
    private PandaProdButton pandaProdButtonLancer;
    private int row, colum;
    
    public MapPPFrame(int row, int colum) {
        this.row = row;
        this.colum = colum;
        initComponents(row, colum);
        putComponents();
        configFrame();
        refresh();
    }

    private void initComponents(int row, int colum) {
        mapJPanel = new JPanel(new GridLayout(row, colum));
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        mapJPanel.setBorder(blackline);
        pandaProdButtonLancer = new PandaProdButton("Lancer");
        JMenuBar menu = new JMenuBar();
        menu.add(pandaProdButtonLancer);
        this.setJMenuBar(menu);
        this.add(mapJPanel);
        
    }

    @Override
    public void putComponents() {
        hsJcomponent.put("mapJPanel", mapJPanel);
        hsJcomponent.put("row", row);
        hsJcomponent.put("colum", colum);
        hsJcomponent.put("pandaProdButtonLancer", pandaProdButtonLancer);
        
    }

}

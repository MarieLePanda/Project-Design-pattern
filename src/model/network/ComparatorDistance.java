/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.network;

import java.util.Comparator;

/**
 *                      
 * @author Mary
 */
public class ComparatorDistance implements Comparator<Edge>{


    @Override
    public int compare(Edge o1, Edge o2) {
        if(o1.getAttribute().getValue() < o2.getAttribute().getValue()){
            return -1;
        }
        if(o1.getAttribute().getValue() > o2.getAttribute().getValue()){
            return 1;
        }
        return 0;
    }
    
    
}

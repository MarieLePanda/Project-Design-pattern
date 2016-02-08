/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.network.mail;

import model.network.interfaces.Open;

/**
 *
 * @author Lucas
 */
public class OpenMail extends Open{

    @Override
    public String open() {
        return "Vous avez ouvert un mail ! ";
    }
    
}

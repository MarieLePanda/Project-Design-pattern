/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import interfaces.action.IAction;
import model.Castlefight;
import model.Fourmiliere;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author iklarman
 */
public class LoadModelCastle implements IAction{

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        application.setMap(new Castlefight());
        application.getMap().loadMap();
        return true;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.action;

import java.util.HashMap;
import view.component.PandaProdFrame;

/**
 *
 * @author mickx
 */
public abstract class AbstractIHMAction implements IAction {
   
    protected HashMap<String, Object> hsJcomponent;

    public AbstractIHMAction(PandaProdFrame csFrame) {
        hsJcomponent = csFrame.getJComponent();
    }
}

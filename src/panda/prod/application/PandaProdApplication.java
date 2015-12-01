package panda.prod.application;


import java.util.HashMap;

import javax.swing.UnsupportedLookAndFeelException;
import model.Network;
import module.ihm.MainFrameInitializeur;

import view.MainPPFrame;
import view.component.PandaProdFrame;

/**
 * Point de démarage de l'application
 *
 * @author Mary
 */
public class PandaProdApplication {

    private static PandaProdApplication application;
    
    
    private PandaProdFrame mainFrame, focusFrame;
    private final HashMap<String,Object> params;
    private Network map;
    //private HashMap<String,Object> params; Compatibilité Java 7

    public Network getMap() {
        return map;
    }

    public void setMap(Network map) {
        this.map = map;
    }
    
    private PandaProdApplication() {
        params = new HashMap<>();
    }
    
    private void start() {
    	initLookAndFeel();       
        MainPPFrame mainFrame = new MainPPFrame();
        this.mainFrame = mainFrame;
        new MainFrameInitializeur(mainFrame).execute();
    }
    
    public void stop() {
        System.exit(0);
    }
    
    private void initLookAndFeel() {
    	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException
        		|InstantiationException
        		|IllegalAccessException
        		|UnsupportedLookAndFeelException ex) {
        }	
    }

	public void setMainFrame(PandaProdFrame mainCSFrame) {
        if(this.mainFrame != null) this.mainFrame.dispose();
        this.mainFrame = mainCSFrame;
    }
    
    public void setFocusFrame(PandaProdFrame focusFrame) {
        if(this.focusFrame != null) this.focusFrame.dispose();
        this.focusFrame = focusFrame;
    }
    
    public PandaProdFrame getFocusFrame() {
        return focusFrame;
    }
    
    public PandaProdFrame getMainFrame() {
        return mainFrame;
    }
    
    public Object getMainFrameJComponent(String identifier) {
        return mainFrame.getJComponent().get(identifier);
    }
    
    public Object getFocusFrameJComponent(String identifier) {
        return focusFrame.getJComponent().get(identifier);
    }
    
    public void setParam(String key, Object value) {
        params.put(key,value);
    }
    
    public Object getParam(String key) {
        return params.get(key);
    }
        
    public static PandaProdApplication getApplication() {
        if(application == null) {
            application = new PandaProdApplication();
        }
        return application;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        PandaProdApplication.getApplication().start();
    }
}

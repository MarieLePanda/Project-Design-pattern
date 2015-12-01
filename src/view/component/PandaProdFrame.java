package view.component;

import java.util.HashMap;

import javax.swing.JFrame;

public abstract class PandaProdFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    protected HashMap<String, Object> hsJcomponent;

    public PandaProdFrame() {
        hsJcomponent = new HashMap<>();
        initBaseComponents();
    }

    private void initBaseComponents() {
        //setBackground(new Color(0, 175, 240));
        //getContentPane().setBackground(new Color(0, 175, 240));
        //setBackground(new Color(44, 62, 80));
        getContentPane().setBackground(PandaProdColor.BACKGROUND_FRAME);
    }

    public HashMap<String, Object> getJComponent() {
        return hsJcomponent;
    }

    abstract public void putComponents();

    public void configFrame() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
        setResizable(false);
    }
    
    public void refresh() {
        validate();
        repaint();
        revalidate();
        pack();
    }

}

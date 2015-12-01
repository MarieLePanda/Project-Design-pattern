package view.component;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

public class PandaProdPasswordField extends JPasswordField {

	public PandaProdPasswordField() {
		super();
		initComponent();
	}

	public PandaProdPasswordField(String arg0) {
		super(arg0);
		initComponent();
	}

	public void initComponent(){
		//setSize(110, 20);
		Border thickBorder = new LineBorder(Color.white, 5);
		setBorder(thickBorder);
	}
}

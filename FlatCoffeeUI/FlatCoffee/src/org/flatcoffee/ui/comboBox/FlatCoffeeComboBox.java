package org.flatcoffee.ui.comboBox;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class FlatCoffeeComboBox<E> extends JComboBox<E> {
	
	
	public FlatCoffeeComboBox () 
	{
		this.setModel(new DefaultComboBoxModel<E>());
		this.setBackground(Color.white) ;
		this.setForeground(Color.black) ;
		initCommon();
	}
	
	public FlatCoffeeComboBox ( Color foreground , Color background) 
	{
		this.setBackground(background) ;
		this.setForeground(foreground) ;
		initCommon();
	}
	
	private void initCommon () 
	{
		this.setUI(new FlatCoffeeComboBoxUI(getForeground(),getBackground())) ;
		this.setRenderer(new FlatCoffeeComboBoxItemRenderer(getForeground(),getBackground()) ) ;
		this.setBorder(BorderFactory.createEmptyBorder()) ;
		this.setOpaque(true);
	}
}

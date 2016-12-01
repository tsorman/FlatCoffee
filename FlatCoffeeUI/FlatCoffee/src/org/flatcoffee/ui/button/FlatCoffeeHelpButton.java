package org.flatcoffee.ui.button;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class FlatCoffeeHelpButton extends JButton{
	
	public FlatCoffeeHelpButton ( Color backGroundColor) 
	{
		this (  backGroundColor , Color.white ) ;
	}
	
	public FlatCoffeeHelpButton ( Color backGroundColor , Color foreGroundColor )
	{
		super("?") ;
        setFont(new Font("Arial", Font.PLAIN, 14));
        setBackground(backGroundColor);
        setForeground(foreGroundColor);
        setContentAreaFilled(false);
        setOpaque(false);
        setUI(new FlatCoffeeHelpButtonUI());
	}

}

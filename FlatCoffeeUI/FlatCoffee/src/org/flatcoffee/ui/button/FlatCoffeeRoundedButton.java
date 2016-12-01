package org.flatcoffee.ui.button;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class FlatCoffeeRoundedButton extends JButton{
	
	public FlatCoffeeRoundedButton ( String text , Color backGroundColor) 
	{
		this ( text , backGroundColor , Color.white ) ;
	}
	
	public FlatCoffeeRoundedButton ( String text , Color backGroundColor , Color foreGroundColor)
	{
		super(text) ;
        setFont(new Font("Arial", Font.PLAIN, 14));
        setBackground(backGroundColor);
        setForeground(foreGroundColor);
        setUI(new FlatCoffeeButtonUI(FlatCoffeeButtonUI.ROUND_ARC));
	}

}

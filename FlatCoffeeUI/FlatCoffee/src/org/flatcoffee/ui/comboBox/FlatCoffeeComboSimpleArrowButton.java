package org.flatcoffee.ui.comboBox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class FlatCoffeeComboSimpleArrowButton extends JButton{
	
	
	public FlatCoffeeComboSimpleArrowButton (Color foreground , Color background) 
	{
		setRolloverEnabled(false) ;
		setBorderPainted(false) ;
		setFocusPainted(false) ;
		setContentAreaFilled(true) ;
		setBackground(background) ;
		setForeground(foreground) ;
		setOpaque(true);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered ( MouseEvent evt ) 
			{

			}
			@Override
			public void mousePressed(MouseEvent e) {
								
			}
		});
		
	}
	
	@Override
	public void paintComponent ( Graphics g )
	{
		Graphics2D graphics = (Graphics2D) g;

		// Sets antialiasing if HQ.
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(getBackground()) ;
		g.drawRect(0, 0, getWidth(), getHeight()) ;

		
		g.setColor(getForeground()) ;
		int[] xPoints = {getWidth()-3, getWidth()-3, getWidth()-10};
	    int[] yPoints = {getHeight()-3 , getHeight()-10 , getHeight() - 3 };
	    g.fillPolygon(xPoints, yPoints, 3);
	    
	   
	}

}

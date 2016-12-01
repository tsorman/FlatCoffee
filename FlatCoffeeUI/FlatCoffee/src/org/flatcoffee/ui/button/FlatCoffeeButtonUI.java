package org.flatcoffee.ui.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

class FlatCoffeeButtonUI extends BasicButtonUI {
	
	protected static int ROUND_ARC = 13 ;
	protected static int SQUARE_ARC = 0 ;

	private static int ARC ;

	public  FlatCoffeeButtonUI( int arc) {
		
		if ( arc == SQUARE_ARC )
			ARC = SQUARE_ARC ;
		else
			ARC = ROUND_ARC ;
	}
	
    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        
        Color FOREGROUND , BACKGROUND , BACKGROUND_OVER , DISABLED;
        
        FOREGROUND = c.getForeground();
        BACKGROUND = c.getBackground() ;
        BACKGROUND_OVER = new Color ( (int) (BACKGROUND.getRed() + (255 - BACKGROUND.getRed()) * 0.6) ,
        							  (int) (BACKGROUND.getGreen() + (255 - BACKGROUND.getGreen()) * 0.6) ,
        							  (int) (BACKGROUND.getBlue() + (255 - BACKGROUND.getBlue()) * 0.6) ) ;
        DISABLED =  new Color ( (int) (BACKGROUND.getRed() + (255 - BACKGROUND.getRed()) * 0.4) ,
        						(int) (BACKGROUND.getGreen() + (255 - BACKGROUND.getGreen()) * 0.4) ,
        						(int) (BACKGROUND.getBlue() + (255 - BACKGROUND.getBlue()) * 0.4) ) ;
        
        
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if ( b.getModel().isEnabled())
        {
        	g.setColor(FOREGROUND);	
        }
        else
        {
        	 g.setColor(DISABLED);	
        }
       	
        
        g.fillRoundRect(0, 0, size.width, size.height, ARC, ARC);
       	g.setColor(BACKGROUND);
       
       	g.fillRoundRect(2, 2, size.width-4, size.height-4 , ARC, ARC);	

        if ( b.getModel().isRollover())
	       	g.setColor(BACKGROUND_OVER);
        else
        	g.setColor(BACKGROUND);
	    g.fillRoundRect(2, 2, size.width-4, size.height-4 , ARC, ARC);
        
        super.paint(g, c);
    }
    
    @Override 
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
    	
    	Color FOREGROUND , BACKGROUND ;
        
        FOREGROUND = b.getForeground();
        BACKGROUND = b.getBackground() ;
    	
    	if ( b.getModel().isEnabled())
    	{
    		if( !b.getModel().isPressed() )
    			super.paintText(g, b, textRect, text);
    		else
    		{
    			g.setColor(BACKGROUND);
        		g.drawString(text, textRect.x, textRect.y + g.getFontMetrics().getAscent());
    		}
    		
    	}
    	else
    	{
    		g.setColor(FOREGROUND.darker().darker());
    		g.drawString(text, textRect.x, textRect.y + g.getFontMetrics().getAscent());
    	}
    }
    
    @Override
    public void paintButtonPressed(Graphics g , AbstractButton b )
    {
        Dimension size = b.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color FOREGROUND , BACKGROUND ;
        
        FOREGROUND = b.getForeground();
        BACKGROUND = b.getBackground() ;
        
       	g.setColor(BACKGROUND);
        g.fillRoundRect(0, 0, size.width, size.height, ARC, ARC);
       	g.setColor(FOREGROUND) ;
        g.fillRoundRect(2, 2, size.width-4, size.height-4 , ARC, ARC);
    }
    
    
    
}
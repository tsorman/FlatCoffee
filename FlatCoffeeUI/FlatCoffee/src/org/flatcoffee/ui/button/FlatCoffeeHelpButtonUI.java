package org.flatcoffee.ui.button;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.AffineTransform;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

class FlatCoffeeHelpButtonUI extends BasicButtonUI {
	
	protected static int ROUND_ARC = 13 ;
	protected static int SQUARE_ARC = 0 ;
	
	private static int ARC ;

	public  FlatCoffeeHelpButtonUI() {
		
//		if ( arc == SQUARE_ARC )
//			ARC = SQUARE_ARC ;
//		else
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
        
        Color  BACKGROUND_OVER , DISABLED;
        
        BACKGROUND_OVER = new Color ( (int) (c.getBackground().getRed() * 0.8) , (int) (c.getBackground().getGreen() * 0.8) , (int) (c.getBackground().getBlue() * 0.8) ) ;
        DISABLED =  new Color ( (int) (b.getForeground().getRed() * 0.8) , (int) (b.getForeground().getGreen() * 0.8) , (int) (b.getForeground().getBlue() * 0.8) ) ;
        
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//        if ( b.getModel().isRollover())
// 	       	g.setColor(BACKGROUND_OVER);
//         else
//    	 if ( !b.getModel().isRollover())
//         	g.setColor(c.getBackground());
//    	 else
//        if ( b.getModel().isEnabled())
//        {
//        	g.setColor(b.getForeground());	
//        }
//        else
//        if ( !b.getModel().isEnabled())
//        {
//        	 g.setColor(DISABLED);	
//        }
        
        g.setColor(c.getBackground());
        
        g.fillArc(0, 0, size.width, size.height, 0, 360);
       	
        if ( !b.getModel().isRollover())
        	g.setColor(b.getForeground());
        else
        	g.setColor( Color.red);
       	
       	g.fillArc( (int)(size.width * 0.05) , (int)(size.height * 0.05) , (int)(size.width -(size.width * 0.1)), (int)(size.height - ( size.height * 0.1)), 0, 360);
       
       	
       	
//       g.fillRoundRect(2, 2, size.width-4, size.height-4 , ARC, ARC);	
//
//        if ( b.getModel().isRollover())
//	       	g.setColor(BACKGROUND_OVER);
//        else
//        	g.setColor(c.getBackground());
//	    g.fillRoundRect(2, 2, size.width-4, size.height-4 , ARC, ARC);
        
        super.paint(g, c);
    }
    
    @Override 
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
    	
    	Font textFont = b.getFont().deriveFont(AffineTransform.getScaleInstance(1, 1));
    	
    	Color FOREGROUND , BACKGROUND ;
        
        FOREGROUND = b.getForeground();
        BACKGROUND = b.getBackground() ;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        
        Font labelFont = b.getFont();
        String labelText = b.getText();

        int stringWidth = b.getFontMetrics(labelFont).stringWidth(labelText);
        int componentWidth = b.getWidth();

        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;

        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = b.getHeight();

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        // Set the label's font size to the newly determined size.
        b.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
    	
        if( b.getModel().isPressed() )
        	g2.setColor(b.getForeground());
        else
        	g2.setColor(b.getBackground());
    	
    	g2.drawString(text, textRect.x, textRect.y + b.getGraphics().getFontMetrics().getAscent());
//    	}
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
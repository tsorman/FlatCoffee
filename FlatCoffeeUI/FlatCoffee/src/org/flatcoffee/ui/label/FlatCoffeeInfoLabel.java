package org.flatcoffee.ui.label;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FlatCoffeeInfoLabel extends JLabel {
	
	public static Color GRAY_INFO_LABEL_COLOR = new Color ( 119 , 119 , 119 ) ;
	public static Color BLUE_INFO_LABEL_COLOR = new Color ( 51 , 122 , 181 );
	public static Color GREEN_INFO_LABEL_COLOR = new Color ( 92 , 184 , 92);
	public static Color LIGHT_BLUE_INFO_LABEL_COLOR = new Color ( 91 , 192 , 222 );
	public static Color ORANGE_INFO_LABEL_COLOR = new Color ( 240 , 173 , 78);
	public static Color RED_INFO_LABEL_COLOR = new Color ( 217 , 83 , 79);
	
	
	public FlatCoffeeInfoLabel( )
	{
		super () ;
	}
	/**
	 * @wbp.parser.constructor
	 */
	public FlatCoffeeInfoLabel( Color color )  {
		super () ;
		init ( color ) ;
	}
	
	public FlatCoffeeInfoLabel( String text ,  Color color )  {
		super () ;
		init (color) ;
		setText(text);
	}
	
	private void init ( Color color) 
	{
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Arial", Font.PLAIN, 11));
		setForeground(Color.WHITE);
		setBackground(color);
	}
	
	@Override
	public void setText ( String text )
	{
		super.setText(text);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;

		// Sets antialiasing if HQ.
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

		// Draws shadow borders if any.

		// Draws the rounded opaque panel with borders.
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width , height,
				8, 8);
		// Sets strokes to default, is better.
		graphics.setStroke(new BasicStroke());
		
		FontMetrics metrics = getGraphics().getFontMetrics(getFont());
		// get the height of a line of text in this
		// font and render context
		int hgt = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int adv = metrics.stringWidth(getText());
		// calculate the size of a box to hold the
		// text with some padding.
		Dimension size = new Dimension(adv+10, hgt+6);
		
		setPreferredSize(size);
		
		revalidate();
		super.paintComponent(g) ;
	}

}

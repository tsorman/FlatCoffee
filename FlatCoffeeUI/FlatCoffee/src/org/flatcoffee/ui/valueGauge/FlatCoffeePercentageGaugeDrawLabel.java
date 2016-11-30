package org.flatcoffee.ui.valueGauge;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import org.flatcoffee.ui.constants.FlatCoffeeColors;

public class FlatCoffeePercentageGaugeDrawLabel extends JComponent 
{
	public FlatCoffeePercentageGaugeDrawLabel() {
		super();
	}
	
	public FlatCoffeePercentageGaugeDrawLabel(int gaugeposition, String displayMaxValue, String displayMinValue, String displayValue) {
		super();
		
		setGaugeposition(gaugeposition) ;
		this.displayMaxValue = displayMaxValue;
		this.displayMinValue = displayMinValue;
		this.displayValue = displayValue;
		
		this.setMinimumSize( new Dimension(10, 30));
	}
	
	
	private int gaugeposition = 0 ;
	
	private String displayMaxValue = "100", displayMinValue = "0" , displayValue = "0";
	
	private Color POSITIVE_COLOR = FlatCoffeeColors.GREEN_INFO_COLOR , NEGATIVE_COLOR = FlatCoffeeColors.RED_INFO_COLOR ;
	
	private boolean showMinMax = true ;
	
	public void showMinMax ( boolean show)
	{
		this.showMinMax = show ;
		repaint(); 
	}
	
	
	public int getGaugeposition() {
		return gaugeposition;
	}

	public void setGaugeposition(int gaugeposition) {
		if ( gaugeposition > 100 || gaugeposition < -100)
			throw new IllegalArgumentException("Gauge value should be between -100 and 100") ;
		this.gaugeposition = gaugeposition;
	}

	public String getDisplayMaxValue() {
		return displayMaxValue;
	}

	public void setDisplayMaxValue(String displayMaxValue) {
		this.displayMaxValue = displayMaxValue;
		repaint(); 
	}

	public String getDisplayMinValue() {
		return displayMinValue;
	}

	public void setDisplayMinValue(String displayMinValue) {
		this.displayMinValue = displayMinValue;
		repaint(); 
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
		repaint(); 
	}

	public Color getPositiveColor() {
		return POSITIVE_COLOR;
	}

	public void setPositiveColor(Color positiveColor) {
		POSITIVE_COLOR = positiveColor;
		repaint () ;
	}

	public Color getNegativeColor() {
		return NEGATIVE_COLOR;
	}

	public void setNegativeColor(Color negativeColor) {
		NEGATIVE_COLOR = negativeColor;
		repaint(); 
	}

	@Override
	public void paint ( Graphics g)
	{
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		graphics.setColor(this.getBackground());
		
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		
		int COMPONENT_CENTER = (this.getWidth()-1) / 2 ;
		int ONE_THIRD_HEIGHT = ((this.getHeight() - 1 ) / 3)*2 ;
		int TWO_THIRDS_HEIGHT = ((this.getHeight() - 1 ) / 3) + 5 ;
		
		
		
		//DRAW VALUE BAR
		if ( gaugeposition > 0 )
		{
			double tintWeight = 0.5 - (double)gaugeposition / 200   ;
			Color barColor = new Color ( (int) (POSITIVE_COLOR.getRed() + ( 255  - POSITIVE_COLOR.getRed() ) * tintWeight ) ,
										 (int) (POSITIVE_COLOR.getGreen() + ( 255  - POSITIVE_COLOR.getGreen() ) * tintWeight ) ,
										 (int) (POSITIVE_COLOR.getBlue() + ( 255  - POSITIVE_COLOR.getBlue() ) * tintWeight ) ) ;
			
			graphics.setColor(barColor);
			
			graphics.fillRect(0, this.getHeight() - 15 , (((this.getWidth()-1) * gaugeposition ) / 100) - 2 , 10 );
			graphics.fillArc( (((this.getWidth()-1) * gaugeposition ) / 100) - 6 , this.getHeight() - 15 , 6, 10, -90, 180);
			
			
		}
		
		
		graphics.setColor(Color.DARK_GRAY);
		
		//BOTTOM LINE RULER
		graphics.drawLine(0, this.getHeight() - 1 , this.getWidth(), this.getHeight() - 1 );
		
		// LEFT CORNER LINE 
		graphics.drawLine(0, TWO_THIRDS_HEIGHT , 0, this.getHeight() - 1 );
		
		//RIGHT CORNER LINE
		graphics.drawLine(getWidth()-1, ONE_THIRD_HEIGHT , this.getWidth() - 1 , this.getHeight() - 1 );
		
		//CENTERLINE
		graphics.drawLine(COMPONENT_CENTER , this.getHeight() - 4 , COMPONENT_CENTER , this.getHeight() - 1 );
		
		//DISPLAYING MIN AND MAX VALUES
		FontMetrics metrics = getGraphics().getFontMetrics(getFont());
		int fonthgt = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		
		graphics.setFont(new Font("Arial", Font.PLAIN, 10));
		
		graphics.drawString(displayValue, (COMPONENT_CENTER -  (metrics.stringWidth(displayValue)/2))+1 , fonthgt - 4   );
		
		if ( showMinMax)
		{
			//DrawMin value
			graphics.drawString(displayMinValue, 4, fonthgt + 2 );
			
			//DrawMax value
			graphics.drawString(displayMaxValue, this.getWidth() - metrics.stringWidth(displayMaxValue) - 2 , fonthgt + 2);
		}
	}
}
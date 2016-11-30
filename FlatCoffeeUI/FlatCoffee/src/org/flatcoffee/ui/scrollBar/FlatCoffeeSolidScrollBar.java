package org.flatcoffee.ui.scrollBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollBar;

public class FlatCoffeeSolidScrollBar extends JScrollBar {
	
	private int DEFAULT_WIDTH = 8 ;
	private int DEFAULT_HEIGHT = 0 ;
	
	private Timer timer = new Timer("Hide");

	public FlatCoffeeSolidScrollBar(Color barColor , Color backgroundColor) {
		super();
		addExtraListeners () ;
		DEFAULT_WIDTH = 8 ;
		setPreferredSize(new Dimension(0  , 0)) ;
		setBackground(backgroundColor) ;
		setUI(new FlatCoffeeSolidScrollBarUI(barColor, backgroundColor)) ;
	}
	
	public FlatCoffeeSolidScrollBar(Color barColor , Color backgroundColor , int width) {
		super();
		addExtraListeners () ;
		DEFAULT_WIDTH = width ;
		setPreferredSize(new Dimension(0  , 0)) ;
		setBackground(backgroundColor) ;
		setUI(new FlatCoffeeSolidScrollBarUI(barColor, backgroundColor)) ;
	}
	
	public FlatCoffeeSolidScrollBar(int orientation  , Color barColor , Color backgroundColor , int width) {
		super(orientation);
		addExtraListeners () ;
			DEFAULT_WIDTH = width ;
		if ( orientation == JScrollBar.HORIZONTAL)
			DEFAULT_HEIGHT = width ;
		setPreferredSize(new Dimension(DEFAULT_WIDTH  , DEFAULT_HEIGHT)) ;
		setBackground(backgroundColor) ;
		setUI(new FlatCoffeeSolidScrollBarUI(barColor, backgroundColor)) ;
	}

	public FlatCoffeeSolidScrollBar(int orientation, int value, int extent,
			int min, int max , Color barColor , Color backgroundColor) {
		super(orientation, value, extent, min, max);
		addExtraListeners () ;
		setBackground(backgroundColor) ;
		setUI(new FlatCoffeeSolidScrollBarUI(barColor, backgroundColor)) ;
	}

	public FlatCoffeeSolidScrollBar(int orientation , Color barColor , Color backgroundColor) {
		super(orientation);
		addExtraListeners () ;
		setBackground(backgroundColor) ;
		setUI(new FlatCoffeeSolidScrollBarUI(barColor, backgroundColor)) ;
	}
	
	public void addExtraListeners () 
	{
//		this.addAdjustmentListener( new AdjustmentListener() {
//			
//			@Override
//			public void adjustmentValueChanged(AdjustmentEvent e) {
//				showScrollBar() ;
//			}
//		}) ;
	}
	
	public void hideScrollBar ()
	{
		setPreferredSize(new Dimension(0  , 0)) ;
	}
	
	public void showScrollBar ( )
	{
		setPreferredSize(new Dimension(DEFAULT_WIDTH  , 0)) ;
		getScrollBarCloseTimer() ;
	}
	
	public Timer getScrollBarCloseTimer () 
	{
		try
		{
			timer.cancel() ;
			timer.purge() ;
		}
		catch ( IllegalStateException exc)
		{
			
		}
		catch ( NullPointerException exc)
		{
			
		}
		
		timer = new Timer("Close");
		timer.schedule(new TimerTask ()  {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				hideScrollBar() ;
			}
	    	   
	       }, 750, 750);
		
		
		
		return timer ;
	}

}

package org.flatcoffee.ui.scrollBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class FlatCoffeeSolidScrollBarUI extends BasicScrollBarUI {
	
		private Color barColor , backgroundColor ;
		
	
		public FlatCoffeeSolidScrollBarUI( Color barColor , Color backgroundColor) {
			super();
			this.barColor = barColor ;
			this.backgroundColor = backgroundColor ;
		}

		@Override
        public void installUI(JComponent c){
            super.installUI(c);
            scrollbar.setOpaque(true);
        }
		
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createButton();
        }

        @Override    
        protected JButton createIncreaseButton(int orientation) {
            return createButton();
        }

        private JButton createButton() {
            JButton jbutton = new JButton();
            jbutton.setPreferredSize(new Dimension(0, 0));
            jbutton.setMinimumSize(new Dimension(0, 0));
            jbutton.setMaximumSize(new Dimension(0, 0));
            return jbutton;
        }
        
        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {        
        	 g.translate( thumbBounds.x, thumbBounds.y );
            Graphics2D graphics = (Graphics2D) g;

    		// Sets antialiasing if HQ.
    		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    				RenderingHints.VALUE_ANTIALIAS_ON);

    		graphics.setColor( backgroundColor );
    		graphics.fillRect(0, 0, thumbBounds.width , thumbBounds.height);
    		
    		graphics.setColor( barColor );
    		graphics.fillRoundRect(1, 1, thumbBounds.width - 2, thumbBounds.height - 2, 5 ,5 );


            g.translate( -thumbBounds.x, -thumbBounds.y );
        }
        
        protected void paintTrack( Graphics g, JComponent c, Rectangle trackBounds )
        {
            g.translate( trackBounds.x, trackBounds.y );
               g.setColor( backgroundColor );
               g.fillRect(0, 0, trackBounds.width - 1, trackBounds.height - 1);
            g.translate( -trackBounds.x, -trackBounds.y );
        }
        
//        protected class DummyTrackListener
//        extends TrackListener
//        {
//        	 public void mouseDragged(MouseEvent e)
//        	 {
//        		 super.mouseDragged(e ) ;
//        	 }
//        }
//        
//        @Override
//        protected TrackListener createTrackListener(){
//        	return new DummyTrackListener();
//            }
//	
}

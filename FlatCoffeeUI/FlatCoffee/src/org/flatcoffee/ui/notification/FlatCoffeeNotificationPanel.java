package org.flatcoffee.ui.notification;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlatCoffeeNotificationPanel extends JPanel {
	
	private static final Color GRAY_INFO_COLOR = new Color ( 119 , 119 , 119 ) ;
	private static final Color BLUE_INFO_COLOR = new Color ( 51 , 122 , 181 );
	private static final Color GREEN_INFO_COLOR = new Color ( 92 , 184 , 92);
	private static final Color ORANGE_INFO_COLOR = new Color ( 240 , 173 , 78);
	private static final Color RED_INFO_COLOR = new Color ( 217 , 83 , 79);
	
	
	private static final Color LIGHT_RED_ALERT_COLOR = new Color ( 242 , 222 , 222);
	private static final Color LIGHT_BLUE_INFO_COLOR = new Color ( 91 , 192 , 222 );
	private static final Color LIGHT_GREEN_INFO_COLOR = new Color ( 76 , 255 , 0);
	
	private Timer timer ;
	
	
	private JLabel textLabel;
	
	public FlatCoffeeNotificationPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		setBackground(LIGHT_RED_ALERT_COLOR);
		
		setVisible(false) ;
		textLabel = new JLabel("New label");
		textLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		textLabel.setForeground(RED_INFO_COLOR);
		GridBagConstraints gbc_textLabel = new GridBagConstraints();
		gbc_textLabel.insets = new Insets(5, 5, 5, 0);
		gbc_textLabel.fill = GridBagConstraints.BOTH;
		gbc_textLabel.gridx = 0;
		gbc_textLabel.gridy = 0;
		add(textLabel, gbc_textLabel);
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
		graphics.setColor(textLabel.getForeground());
		graphics.fillRoundRect(0, 0, width , height,
				10, 10);
		// Sets strokes to default, is better.
		graphics.setColor(getBackground());
		graphics.fillRoundRect(1, 1, width-2 , height-2,
				10, 10);
		
		
		graphics.setStroke(new BasicStroke());
		
		
		
		FontMetrics metrics = getGraphics().getFontMetrics(getFont());
		// get the height of a line of text in this
		// font and render context
		int hgt = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int adv = metrics.stringWidth(textLabel.getText());
		// calculate the size of a box to hold the
		// text with some padding.
		Dimension size = new Dimension(adv+5, hgt+6);
		
		setPreferredSize(size);
		
//		revalidate();
//		super.paintComponent(g) ;
	}
	
	public void showErrorMessage ( String messageText)
	{
		setBackground(LIGHT_RED_ALERT_COLOR);
		textLabel.setForeground(RED_INFO_COLOR);
		textLabel.setText(messageText);
		setVisible(true); 
		startTimer () ;
	}
	
	public void showInfoMessage ( String messageText)
	{
		setBackground(LIGHT_GREEN_INFO_COLOR);
		textLabel.setForeground(GREEN_INFO_COLOR);
		textLabel.setText(messageText);
		setVisible(true);
		startTimer () ;
	}
	
	private void startTimer () 
	{
		timer = new Timer() ;
		timer.schedule(new TimerTask() {
			  @Override
			  public void run() {
			   setVisible(false);
			  }
			}, 10000); 
	}

}

package org.flatcoffee.ui.tagViewer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public abstract class FlatCoffeeTagElement extends JPanel {
	private JTextField textHolder;
	private JLabel removeLabel;
	
	private String tempText ;

	/**
	 * Create the panel.
	 */
	public FlatCoffeeTagElement() {
		initUIElements ("New Tag") ;
	}
	
	public FlatCoffeeTagElement( String displayName) {
		initUIElements (displayName) ;
	}
	
	private void initUIElements ( String initialText) 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 0, 0};
		gridBagLayout.rowHeights = new int[]{33, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setFocusable(true);
		
		textHolder = new JTextField(initialText);
		textHolder.setFont(new Font("Arial", Font.PLAIN, 11));
//		textHolder.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent arg0) {
//				 deselectText () ;
//				 textHolder.setText(tempText);
//			}
//		});
		textHolder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( arg0.getClickCount() == 2 )
				editText () ;
			}
		});
		textHolder.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				 if ( arg0.getKeyCode() == KeyEvent.VK_ENTER )
				 {
					 deselectText () ;
					 tagUpdated ( textHolder.getText() ) ;
				 }
				
				 if ( arg0.getKeyCode() == KeyEvent.VK_ESCAPE )
				 {
					 
					 deselectText () ;
					 textHolder.setText(tempText);
				 }
			}
			
		});
		textHolder.setBorder(null);
		textHolder.setEditable(false);
		textHolder.setForeground(Color.BLACK);
		textHolder.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textLabel = new GridBagConstraints();
		gbc_textLabel.insets = new Insets(0, 5, 0, 2);
		gbc_textLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLabel.gridx = 0;
		gbc_textLabel.gridy = 0;
		add(textHolder, gbc_textLabel);
		
		removeLabel = new JLabel("X");
		removeLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		removeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				removeTagElement () ;
			}
		});
		GridBagConstraints gbc_removeLabel = new GridBagConstraints();
		gbc_removeLabel.insets = new Insets(0, 0, 0, 15);
		gbc_removeLabel.fill = GridBagConstraints.VERTICAL;
		gbc_removeLabel.gridx = 1;
		gbc_removeLabel.gridy = 0;
		add(removeLabel, gbc_removeLabel);
	}
	
	private void deselectText () 
	{
		textHolder.setSelectionStart(0);
		 textHolder.setSelectionEnd(0);
		 textHolder.setEditable(false);
		 requestFocus();
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
		graphics.setColor(Color.lightGray);
		graphics.fillRect(0, 0, width , height );
		// Sets strokes to default, is better.
		graphics.setColor(getBackground());
		graphics.fillRect(1, 1, width-2 , height-2 );
		
		
		graphics.setStroke(new BasicStroke());
		
		FontMetrics metrics = getGraphics().getFontMetrics(getFont());
		// get the height of a line of text in this
		// font and render context
		int hgt = metrics.getHeight();
		// get the advance of my text in this font
		// and render context
		int adv = metrics.stringWidth(textHolder.getText());
		// calculate the size of a box to hold the
		// text with some padding.
		Dimension size = new Dimension(adv+20+removeLabel.getWidth(), hgt+4);
		
		setPreferredSize(size);
		
	}
	
	public void editText () 
	{
		tempText = textHolder.getText() ;
		textHolder.setEditable(true);
		textHolder.selectAll();
		textHolder.requestFocus();
	}
	
	public String getTagName () 
	{
		return textHolder.getText() ;
	}
	
	public abstract void removeTagElement () ;
	
	public abstract void tagUpdated ( String newTagName ) ;

}

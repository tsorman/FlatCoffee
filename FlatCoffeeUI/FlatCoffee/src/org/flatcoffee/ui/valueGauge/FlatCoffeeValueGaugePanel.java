package org.flatcoffee.ui.valueGauge;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FlatCoffeeValueGaugePanel extends JPanel{
	private int value ;
	private String title ="title" ;
	private JLabel titleLabel;
	private JLabel valueLabel ;
	
	
	public FlatCoffeeValueGaugePanel() {
		setBackground(Color.WHITE);
		initElements ( ) ;
	}
	
	public FlatCoffeeValueGaugePanel( String title) {
		this.title = title ;
		
		initElements ( ) ;
	}
	
	public FlatCoffeeValueGaugePanel( String title , String displayValue , int value ) {
		this.title = title ;
//		this.displayValue = displayValue ;
		
		if ( value > 100 || value < -100 )
			throw new IllegalArgumentException("Value should be between -100 and 100") ;
		
		
		initElements ( ) ;
	}
	
	private void initElements ( )
	{
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 45, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.anchor = GridBagConstraints.WEST;
		gbc_titleLabel.insets = new Insets(2, 5, 0, 0);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		add(titleLabel, gbc_titleLabel);
		
		valueLabel = new JLabel();
		valueLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		GridBagConstraints gbc_valueLabel = new GridBagConstraints();
		gbc_valueLabel.gridx = 0;
		gbc_valueLabel.gridy = 1;
		add(valueLabel, gbc_valueLabel);
		
		FlatCoffeeGaugeDrawLabel gauseDrawLabel = new FlatCoffeeGaugeDrawLabel();
		gauseDrawLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_gauseDrawLabel = new GridBagConstraints();
		gbc_gauseDrawLabel.insets = new Insets(0, 5, 5, 5);
		gbc_gauseDrawLabel.fill = GridBagConstraints.BOTH;
		gbc_gauseDrawLabel.gridx = 0;
		gbc_gauseDrawLabel.gridy = 2;
		add(gauseDrawLabel, gbc_gauseDrawLabel);
	}
	
	private void setTitle ( )
	{
		
	}
	


}

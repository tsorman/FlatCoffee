package org.flatcoffee.ui.comboBox;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class FlatCoffeeComboBoxItemRenderer extends BasicComboBoxRenderer{
	
	private Color background, foreground ;
	
	public FlatCoffeeComboBoxItemRenderer(Color foreground , Color background) {
		super() ;
		
		this.background = background ;
		this.foreground = foreground ;
		
		initComponents();
	}
	private void initComponents() {
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		list.setSelectionBackground(background);
		list.setSelectionForeground(foreground);
		
		if ( isSelected)
		{
			setBackground(foreground );
			setForeground(background);
		}
		else
		{
			setBackground(background) ;
			setForeground(foreground) ;
		}
		
		if ( value != null)
			setText(value.toString()) ;
		
		
		return this;
	}

}

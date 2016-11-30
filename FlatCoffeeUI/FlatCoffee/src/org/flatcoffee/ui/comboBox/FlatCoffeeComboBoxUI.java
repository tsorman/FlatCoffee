package org.flatcoffee.ui.comboBox;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import org.flatcoffee.ui.scrollBar.FlatCoffeeSolidScrollBar;

public class FlatCoffeeComboBoxUI extends BasicComboBoxUI {
	
	
	public FlatCoffeeComboBoxUI(Color foreground , Color background) {
		super();
		arrowButton = new FlatCoffeeComboSimpleArrowButton(foreground , background ) ;
	}

	@Override protected JButton createArrowButton() {
        return arrowButton ; 
    }
	
    @Override
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
            @Override
            protected JScrollPane createScroller() {
                JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroller.setVerticalScrollBar( new FlatCoffeeSolidScrollBar(JScrollBar.VERTICAL ,arrowButton.getForeground(), arrowButton.getBackground() , 8));
                return scroller;
            }
        };
    }

}

package org.flatcoffee.ui.tagViewer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlatCoffeeTagViewerPanel extends JPanel {
	private JLabel addLabel;
	
	private FlatCoffeeTagViewerAbstractModel model ;
	private JPanel tagsPanel;
	
	private String defaultTagname = "New Tag" ;

	/**
	 * Create the panel.
	 */
	public FlatCoffeeTagViewerPanel() {
		
		
		model = new FlatCoffeeDefaultTagViewerModel<String>() {
			public String updateElement ( String objectToUpdate , String newDisplayValue ) 
			{
				return newDisplayValue ;
			}

		};
		
		model.assignParentTabViewer (this) ;
		
		initUIElements () ;
	}
	
	public FlatCoffeeTagViewerPanel ( String defaultTagName)
	{
		this () ;
		this.defaultTagname = defaultTagName ;
	}
	
	private void initUIElements () 
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
//		setFocusable(true);
		
		tagsPanel = new JPanel();
		GridBagConstraints gbc_tagsPanel = new GridBagConstraints();
		gbc_tagsPanel.anchor = GridBagConstraints.WEST;
		gbc_tagsPanel.insets = new Insets(0, 0, 0, 5);
		gbc_tagsPanel.gridx = 0;
		gbc_tagsPanel.gridy = 0;
		add(tagsPanel, gbc_tagsPanel);
		
		addLabel = new JLabel("");
		addLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				addLabel.requestFocus(); 
				
//				TagElement tempElement = new TagElement(defaultTagname)
//						{
//							public void removeTagElement () {
//								for ( int a = 0 ; a < tagsPanel.getComponentCount() ; a ++)
//								{
//									if (tagsPanel.getComponent(a) == this)
//									{
//										System.out.println("tag");
//										model.removeTagAt(a) ;
//										break ;
//									}
//								}
//								
//								redrawTags();
//							}
//					
//						} ;
//				model.addTag(tempElement.getTagName()) ;
				model.addTag(defaultTagname) ;
//				tagsPanel.add(  tempElement ) ;
//				tagsPanel.revalidate(); 
//				tempElement.editText(); 
				redrawTags(); 

				
			}
		});
		addLabel.setIcon(new ImageIcon(FlatCoffeeTagViewerPanel.class.getResource("/org/flatcoffee/ui/tagViewer/icons/plus27.png")));
		GridBagConstraints gbc_addLabel = new GridBagConstraints();
		gbc_addLabel.insets = new Insets(0, 0, 0, 5);
		gbc_addLabel.gridx = 1;
		gbc_addLabel.gridy = 0;
		add(addLabel, gbc_addLabel);
//		
//		addMouseListener( new MouseAdapter() {
//			
//			public void mouseClicked () 
//			{
//				requestFocus(); 
//			}
//		});
	}
	
	protected void redrawTags () 
	{
		tagsPanel.removeAll(); 
		
		for ( int a = 0 ; a < model.getSize() ; a++)
		{
			tagsPanel.add(new FlatCoffeeTagElement(model.getDisplayName(a))
			{
				public void removeTagElement () {
					for ( int a = 0 ; a < tagsPanel.getComponentCount() ; a ++)
					{
						if (tagsPanel.getComponent(a) == this)
						{
							model.removeTagAt(a) ;
							break ;
						}
					}
					
					redrawTags();
				}

				@Override
				public void tagUpdated(String newTagName) {
					// TODO Auto-generated method stub
					
					for ( int a = 0 ; a < tagsPanel.getComponentCount() ; a ++)
					{
						if (tagsPanel.getComponent(a) == this)
						{
							System.out.println("update");
							model.updateTagAt(a, newTagName);
							break ;
						}
					}
					
					redrawTags();
				}
		
			} );
			tagsPanel.revalidate(); 
		}
	}
	
	public FlatCoffeeTagViewerAbstractModel getModel ()
	{
		return model ;
	}
	
	public void setDefaultTagName ( String defaultTagName)
	{
		this.defaultTagname = defaultTagName ;
	}
	
	protected void elementUpdateFired ( int index , String newTagName ) 
	{
		model.updateTagAt(index, model.updateElement(model.getElementAt(index), newTagName)); 
	}
	
	public void removeAllTags () 
	{
		model.clearAll();
		tagsPanel.removeAll(); 
	}
	
	protected void clearFromModel () 
	{
		tagsPanel.removeAll();
		tagsPanel.revalidate();
	}

}

package org.flatcoffee.ui.tagViewer;

public abstract class FlatCoffeeTagViewerAbstractModel<T> {
	
	protected FlatCoffeeTagViewerPanel parent ;
	
	public abstract boolean addTag ( T tag ) ;
	
	protected void assignParentTabViewer(FlatCoffeeTagViewerPanel parent) {
		this.parent = parent ; 
	} ;
	
	protected abstract void updateTagAt ( int index , T newTagValue) ;
	
	public abstract int getSize () ;
	
	public abstract String getDisplayName ( int a  ) ;
	
	public abstract T removeTagAt ( int index) ;
	
	public abstract T getElementAt ( int index ) ;
	
	public abstract T updateElement ( T objectToUpdate , String newValue ) ;
	
	public abstract void clearAll () ;
}

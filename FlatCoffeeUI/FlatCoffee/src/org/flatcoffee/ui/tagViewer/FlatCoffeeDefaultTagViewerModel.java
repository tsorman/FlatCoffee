package org.flatcoffee.ui.tagViewer;

import java.util.ArrayList;
import java.util.List;

public abstract class FlatCoffeeDefaultTagViewerModel<T> extends FlatCoffeeTagViewerAbstractModel<T> {
	
	private List<T> tags ;
	
	
	public FlatCoffeeDefaultTagViewerModel () 
	{
		tags = new ArrayList<T> () ;
	}
	
	public boolean addTag ( T tag )
	{
		if (  tags.add(tag) )
		{
			parent.redrawTags();
			return true ;
		}
		return false ;
	}
	
	public boolean removeTag ( T tag)
	{
		return tags.remove(tag) ;
	}
	
	public T removeTagAt ( int index)
	{
		return tags.remove(index) ;
	}
	
	public String getDisplayName ( int a  )
	{
		return tags.get(a).toString() ;
	}
	
	public int getSize () 
	{
		return tags.size() ;
	}
	
	public void clearAll () 
	{
		tags.clear();
		parent.clearFromModel () ;
	}
	
	protected void updateTagAt ( int index , T newTagValue)
	{
		tags.set(index, newTagValue) ;
		parent.redrawTags(); 
	}
	
	public T getElementAt ( int index )
	{
		return tags.get(index) ;
	}
	
	
}

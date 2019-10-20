package edu.northeastern.cs5200.daos;

public class WidgetDao implements WidgetImpl{
	private static WidgetDao instance = null;
	  public WidgetDao() {
		  
	  }
	  public static WidgetDao getInstance() {
		  if(instance == null) 
			  {instance = new WidgetDao();}
		  return instance;
	  }
}

package edu.northeastern.cs5200.daos;

public class PageDao implements PageImpl{
	  private static PageDao instance = null;
	  public PageDao() {
		  
	  }
	  public static PageDao getInstance() {
		  if(instance == null) 
			  {instance = new PageDao();}
		  return instance;
	  }
}

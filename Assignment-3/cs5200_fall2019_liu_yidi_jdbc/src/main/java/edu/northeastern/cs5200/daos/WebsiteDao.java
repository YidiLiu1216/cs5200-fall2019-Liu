package edu.northeastern.cs5200.daos;

public class WebsiteDao implements WebsiteImpl{
	private static WebsiteDao instance = null;
	  public WebsiteDao() {
		  
	  }
	  public static WebsiteDao getInstance() {
		  if(instance == null) 
			  {instance = new WebsiteDao();}
		  return instance;
	  }
}

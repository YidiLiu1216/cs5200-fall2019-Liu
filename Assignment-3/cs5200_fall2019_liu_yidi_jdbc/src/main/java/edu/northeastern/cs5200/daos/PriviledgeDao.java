package edu.northeastern.cs5200.daos;

public class PriviledgeDao implements PriviledgeImpl{
	private static PriviledgeDao instance = null;
	  public PriviledgeDao() {
		  
	  }
	  public static PriviledgeDao getInstance() {
		  if(instance == null) 
			  {instance = new PriviledgeDao();}
		  return instance;
	  }
}

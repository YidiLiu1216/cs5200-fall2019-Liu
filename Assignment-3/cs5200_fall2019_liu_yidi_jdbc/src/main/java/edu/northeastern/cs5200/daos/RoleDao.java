package edu.northeastern.cs5200.daos;

public class RoleDao implements RoleImpl{
	private static RoleDao instance = null;
	  public RoleDao() {
		  
	  }
	  public static RoleDao getInstance() {
		  if(instance == null) 
			  {instance = new RoleDao();}
		  return instance;
	  }
}

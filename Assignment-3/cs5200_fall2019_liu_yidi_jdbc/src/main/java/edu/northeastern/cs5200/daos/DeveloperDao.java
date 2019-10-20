package edu.northeastern.cs5200.daos;

public class DeveloperDao implements DeveloperImpl {
  private static DeveloperDao instance = null;
  public DeveloperDao() {
	  
  }
  public static DeveloperDao getInstance() {
	  if(instance == null) 
		  {instance = new DeveloperDao();}
	  return instance;
  }
}

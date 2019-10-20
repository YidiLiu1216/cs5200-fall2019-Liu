package edu.northeastern.cs5200.daos;

public class UserDao implements UserImpl{
	private static UserDao instance = null;
	  public UserDao() {
		  
	  }
	  public static UserDao getInstance() {
		  if(instance == null) 
			  {instance = new UserDao();}
		  return instance;
	  }
}

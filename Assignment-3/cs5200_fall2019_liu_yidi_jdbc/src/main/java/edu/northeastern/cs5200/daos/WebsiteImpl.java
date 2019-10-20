package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.Website;

public interface WebsiteImpl {
	default void createWebsiteForDeveloper(int developerId, Website website) {
		String create_website="insert into website(id,name,description,visits,developer,created,updated)values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(create_website);
			statement.setLong(1,website.getId());
			statement.setString(2,website.getName());
			statement.setString(3,website.getDescription());
			statement.setLong(4,website.getVisits());
			statement.setLong(5,developerId);
			statement.setString(6,website.getCreated());
			statement.setString(7,website.getUpdated());
			statement.executeUpdate();
			
			Connection.closeConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
default Collection<Website> findAllWebsites() {
	Statement statement;
	  ArrayList<Website> w = new ArrayList<Website>();
	try {
		statement = Connection.getConnection().createStatement();
		String find_person="SELECT * from website";
	    ResultSet  result = statement.executeQuery(find_person);
	    while (result.next()) {
	    	Website w1=new Website(result.getInt("id"),result.getString("name"),result.getString("description"),result.getString("created"),result.getString("updated"),result.getInt("visits"));
	    	w.add(w1);
	    }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	Connection.closeConnection();
  return w;
}
default Collection<Website> findWebsitesForDeveloper(int developerId){
	Statement statement;
	  ArrayList<Website> w = new ArrayList<Website>();
	try {
		statement = Connection.getConnection().createStatement();
		String find_person="SELECT * from website where website.developer="+developerId;
	    ResultSet  result = statement.executeQuery(find_person);
	    while (result.next()) {
	    	Website w1=new Website(result.getInt("id"),result.getString("name"),result.getString("description"),result.getString("created"),result.getString("updated"),result.getInt("visits"));
	    	w.add(w1);
	    }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	Connection.closeConnection();
return w;
}
default Website findWebsiteById(int websiteId) {
	Statement statement;
	Website w=null;
	try {
		statement = Connection.getConnection().createStatement();	
		String find_person="SELECT * from website where website.id="+websiteId;
	    ResultSet  result = statement.executeQuery(find_person);
	    while (result.next()) {
	    	 w=new Website(result.getInt("id"),result.getString("name"),result.getString("description"),result.getString("created"),result.getString("updated"),result.getInt("visits"));
	    }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	Connection.closeConnection();
    return w;
}
default int updateWebsite(int websiteId, Website website) {
	 Statement statement;
	    try {
			statement = Connection.getConnection().createStatement();
			String find_person="update website set website.name='"+website.getName()
			+"',website.description='"+website.getDescription()+
			"',website.created="+website.getCreated()+
			",website.updated="+website.getUpdated()+
			",website.visits="+website.getVisits()+
			" where website.id="+websiteId;
		    return statement.executeUpdate(find_person);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Connection.closeConnection();
		 return-1;
	    }
default int deleteWebsite(int websiteId) {
	Statement statement;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="delete from website where website.id="+websiteId;
		    return statement.executeUpdate(find_person);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
     return-1;
}

}


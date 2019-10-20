package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;

public interface PageImpl {
	 default void createPageForWebsite(int websiteId, Page page) {
		 String create_page="insert into page(id,title,description,views,website,created,updated)values(?,?,?,?,?,?,?)";
		 try {
				PreparedStatement statement = Connection.getConnection().prepareStatement(create_page);
				statement.setLong(1,page.getId());
				statement.setString(2,page.getTitle());
				statement.setString(3,page.getDescription());
				statement.setLong(4,page.getViews());
				statement.setLong(5,websiteId);
				statement.setString(6,page.getCreated());
				statement.setString(7,page.getUpdated());
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
	default Collection<Page> findAllPages() {
		Statement statement;
		  ArrayList<Page> p = new ArrayList<Page>();
		try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT * from page";
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	Page p1=new Page(result.getInt("id"),result.getString("title"),result.getString("description"),result.getString("created"),result.getString("updated"),result.getInt("views"));
		    	p.add(p1);
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Connection.closeConnection();
	  return p;
	}
	default  Page findPageById(int pageId) {
		Statement statement;
		Page p=null;
		try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT * from page where page.id="+pageId;
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	p=new Page(result.getInt("id"),result.getString("title"),result.getString("description"),result.getString("created"),result.getString("updated"),result.getInt("views"));
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Connection.closeConnection();
	  return p;
	}
	default Collection<Page> findPagesForWebsite(int websiteId){
		Statement statement;
		ArrayList<Page> p = new ArrayList<Page>();
		try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT * from page where page.website="+websiteId;
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	Page p1=new Page(result.getInt("id"),result.getString("title"),result.getString("description"),result.getString("created"),result.getString("updated"),result.getInt("views"));
		        p.add(p1);
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Connection.closeConnection();
	  return p;
	}
	default int updatePage(int pageId, Page page) {
		 Statement statement;
		    try {
				statement = Connection.getConnection().createStatement();
				String find_person="update page set page.title='"+page.getTitle()
				+"',page.description='"+page.getDescription()+
				"',page.created="+page.getCreated()+
				",page.updated="+page.getUpdated()+
				",page.views="+page.getViews()+
				" where page.id="+pageId;
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
	default  int deletePage(int pageId) {
		Statement statement;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from page where page.id="+pageId;
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

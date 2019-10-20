package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.northeastern.cs5200.Connection;

public interface PriviledgeImpl {
	 default void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		 String create_wp="insert into website_priviledge(prilviledge,website,developer)values(?,?,?)";
		 try {
				PreparedStatement statement = Connection.getConnection().prepareStatement(create_wp);
				statement.setString(1,priviledge);
				statement.setInt(2,websiteId);
				statement.setInt(3,developerId);
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
	 default void  assignPagePriviledge(int developerId, int pageId, String priviledge) {
		 String create_pp="insert into page_priviledge(priviledge,page,developer)values(?,?,?)";
		 try {
				PreparedStatement statement = Connection.getConnection().prepareStatement(create_pp);
				statement.setString(1,priviledge);
				statement.setLong(2,pageId);
				statement.setLong(3,developerId);
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
	 default void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		 Statement statement;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from website_priviledge where website_priviledge.priviledge='"+priviledge+"' and website_priviledge.website="+websiteId+" and website_priviledge.developer="+developerId;
			    statement.executeUpdate(find_person);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Connection.closeConnection();
	 }
	 default void  deletePagePriviledge(int developerId, int pageId, String priviledge) {
		 Statement statement;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from website_priviledge where page_priviledge.priviledge='"+priviledge+"' and page_priviledge.page="+pageId+" and page_priviledge.developer="+developerId;
			    statement.executeUpdate(find_person);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Connection.closeConnection();
	 }
}

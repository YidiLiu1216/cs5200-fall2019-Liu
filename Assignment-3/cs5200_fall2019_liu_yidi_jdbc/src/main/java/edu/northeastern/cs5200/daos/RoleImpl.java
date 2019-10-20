package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import edu.northeastern.cs5200.Connection;

public interface RoleImpl {
	 default void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		 String create_wr="insert into website_role(role,website,developer)values(?,?,?)";
		 try {
				PreparedStatement statement = Connection.getConnection().prepareStatement(create_wr);
				statement.setInt(1,roleId);
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
	 default void assignPageRole(int developerId, int pageId, int roleId) {
		 String create_pr="insert into page_role(role,page,developer)values(?,?,?)";
		 try {
				PreparedStatement statement = Connection.getConnection().prepareStatement(create_pr);
				statement.setLong(1,roleId);
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
	 default void  deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		 Statement statement;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from website_role where website_role.role="+roleId+" and website_role.website="+websiteId+" and website_role.developer="+developerId;
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
	 default void deletePageRole(int developerId, int pageId, int roleId) {
		 Statement statement;
		 try {
				statement = Connection.getConnection().createStatement();
				String find_person="delete from page_role where page_role.role="+roleId+" and page_role.page="+pageId+" and page_role.developer="+developerId;
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

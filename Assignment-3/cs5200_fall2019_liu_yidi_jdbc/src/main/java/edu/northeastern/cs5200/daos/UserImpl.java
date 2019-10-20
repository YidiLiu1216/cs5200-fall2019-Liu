package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.User;

public interface UserImpl {
	default void createUser(User user){
		  
		String create_person="insert into person(id,firstname,lastname,username,password,email,dob)values(?,?,?,?,?,?,?)";
		String create_user="insert into user(id,user_agreement)values(?,?)";
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(create_person);
			statement.setLong(1,user.getPerson().getId());
			statement.setString(2,user.getPerson().getFirstname());
			statement.setString(3,user.getPerson().getLastname());
			statement.setString(4,user.getPerson().getUsername());
			statement.setString(5,user.getPerson().getPassword());
			statement.setString(6,user.getPerson().getEmail());
			statement.setString(7,user.getPerson().getDob());
			statement.executeUpdate();
			statement = Connection.getConnection().prepareStatement(create_user);
			statement.setLong(1,user.getPerson().getId());
			statement.setBoolean(2, user.getUseragreement());
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
}

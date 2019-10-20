package edu.northeastern.cs5200.daos;

import java.sql.Date;
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

public interface DeveloperImpl {
  default void createDeveloper(Developer developer){
	  
		String create_person="insert into person(id,firstname,lastname,username,password,email,dob)values(?,?,?,?,?,?,?)";
		String create_developer="insert into developer(id,developer_key)values(?,?)";
		try {
			PreparedStatement statement = Connection.getConnection().prepareStatement(create_person);
			statement.setLong(1,developer.getPerson().getId());
			statement.setString(2,developer.getPerson().getFirstname());
			statement.setString(3,developer.getPerson().getLastname());
			statement.setString(4,developer.getPerson().getUsername());
			statement.setString(5,developer.getPerson().getPassword());
			statement.setString(6,developer.getPerson().getEmail());
			statement.setString(7,developer.getPerson().getDob());
			statement.executeUpdate();
			statement = Connection.getConnection().prepareStatement(create_developer);
			statement.setLong(1,developer.getPerson().getId());
			statement.setString(2, developer.getDeveloperKey());
			statement.executeUpdate();
			if(developer.getPerson().getAddress().size()!=0) {
				Iterator<Address> t = developer.getPerson().getAddress().iterator();
				while (t.hasNext()) {
					String create_address="insert into address(street1,street2,city,state,zip,address.primary,person)values(?,?,?,?,?,?,?)";
					statement = Connection.getConnection().prepareStatement(create_address);
					Address temp=t.next();
					statement.setString(1, temp.getStreet1());
					statement.setString(2, temp.getStreet2());
					statement.setString(3, temp.getCity());
					statement.setString(4, temp.getState());
					statement.setString(5, temp.getZip());
					statement.setBoolean(6, temp.getAddress_pri());
					statement.setInt(7, developer.getPerson().getId());
					statement.executeUpdate();
				}
			}
            if(developer.getPerson().getPhones().size()!=0) {
            	Iterator<Phone> t = developer.getPerson().getPhones().iterator();
            	while(t.hasNext()) {
            	  String create_phone="insert into phone(phone,phone.primary,person)values(?,?,?)";
				  statement = Connection.getConnection().prepareStatement(create_phone);
				  Phone temp=t.next();
				  statement.setString(1, temp.getPhone());
				  statement.setBoolean(2, temp.getPhone_pri());
				  statement.setInt(3, developer.getPerson().getId());
				  statement.executeUpdate();
				}
			}
			Connection.closeConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
 default Collection<Developer> findAllDevelopers(){
	  Statement statement;
	  ArrayList<Developer> d = new ArrayList<Developer>();
	try {
		statement = Connection.getConnection().createStatement();
		String find_person="SELECT person.id,person.firstname,person.lastname,person.username,person.email,person.dob,developer.developer_key " + 
			  		"from (person join developer on person.id=developer.id)";
	    ResultSet  result = statement.executeQuery(find_person);
	    while (result.next()) {
	    	Developer d1=new Developer(result.getString("developer_key"),result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("username"),result.getString("email"),result.getString("dob"));
	    	d.add(d1);
	    }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	Connection.closeConnection();
    return d;
  }
 default Developer findDeveloperById(int developerId) {
	 Statement statement;
	 Developer d1=null;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT person.id,person.firstname,person.lastname,person.username,person.email,person.dob,developer.developer_key from (person join developer on person.id=developer.id) where developer.id="+developerId;
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	 d1=new Developer(result.getString("developer_key"),result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("username"),result.getString("email"),result.getString("dob"));
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
	 return d1;
 }
 default  Developer findDeveloperByUsername(String username) {
	 Statement statement;
	 Developer d1=null;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT person.id,person.firstname,person.lastname,person.username,person.email,person.dob,developer.developer_key from (person join developer on person.id=developer.id) where person.username='"+username+"'";
		    ResultSet  result = statement.executeQuery(find_person);
		    while(result.next()) {
		    	 d1=new Developer(result.getString("developer_key"),result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("username"),result.getString("email"),result.getString("dob"));
		    }
		    find_person="select address.* from address where address.person="+d1.getPerson().getId();
	    	 ResultSet result1 = statement.executeQuery(find_person);
	    	 while(result1.next()) {
	    		 Address ad=new Address();
	    		 ad.setId(result1.getInt("id"));
	    		 ad.setStreet1(result1.getString("street1"));
	    		 ad.setStreet2(result1.getString("street2"));
	    		 ad.setCity(result1.getString("city"));
	    		 ad.setState(result1.getString("state"));
	    		 ad.setZip(result1.getString("zip"));
	    		 ad.setAddress_pri(result1.getBoolean("primary"));
	    		 ad.setPerson(d1.getPerson());
	    		 d1.getPerson().addAddress(ad);
	    	 }
	    	 find_person="select phone.* from phone where phone.person="+d1.getPerson().getId();
	    	 result1 = statement.executeQuery(find_person);
	    	 while(result1.next()) {
	    		 Phone ad=new Phone();
	    		 ad.setId(result1.getInt("id"));
	    		 ad.setPhone(result1.getString("phone"));
	    		 ad.setPhone_pri(result1.getBoolean("primary"));
	    		 ad.setPerson(d1.getPerson());
	    		 d1.getPerson().addPhone(ad);
	    }
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
	 return d1;
 }
 default  Developer findDeveloperByCredentials(String username, String password) {
	 Statement statement;
	 Developer d1=null;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="SELECT person.id,person.firstname,person.lastname,person.username,person.email,person.dob,developer.developer_key from (person join developer on person.id=developer.id) where developer.developer_key='"+password+"' and person.username='"+username+"'";
		    ResultSet  result = statement.executeQuery(find_person);
		    while (result.next()) {
		    	 d1=new Developer(result.getString("developer_key"),result.getInt("id"),result.getString("firstname"),result.getString("lastname"),result.getString("username"),result.getString("email"),result.getString("dob"));
		    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection.closeConnection();
	 return d1;
 }
default  int updateDeveloper(int developerId, Developer developer) {
    Statement statement;
    try {
		statement = Connection.getConnection().createStatement();
		String find_person="update person set person.firstname='"+developer.getPerson().getFirstname()
		+"',person.lastname='"+developer.getPerson().getLastname()+
		"',person.username='"+developer.getPerson().getUsername()+
		"',person.password='"+developer.getPerson().getPassword()+
		"',person.email='"+developer.getPerson().getEmail()+
		"',person.dob="+developer.getPerson().getDob()+" where person.id="+developerId;
	    statement.executeUpdate(find_person);
	    find_person="update developer set developer.developer_key='"+developer.getDeveloper_Key()+"' where developer.id="+developerId;
	    statement.executeUpdate(find_person);
		if(developer.getPerson().getAddress().size()!=0) {
			Iterator<Address> t = developer.getPerson().getAddress().iterator();
			while (t.hasNext()) {
				Address temp=t.next();
				find_person="update address set street1='"+temp.getStreet1()+"',street2='"+temp.getStreet2()+
						"',city='"+temp.getCity()+"',state='"+temp.getState()+"',zip='"+temp.getZip()+
						"',address.primary="+temp.getAddress_pri()+",person="+developerId+" where address.id="+temp.getId();
				
				statement.executeUpdate(find_person);
			}
		}
        if(developer.getPerson().getPhones().size()!=0) {
        	Iterator<Phone> t = developer.getPerson().getPhones().iterator();
        	while(t.hasNext()) {
			  Phone temp=t.next();
			  String create_phone="update phone set phone='"+temp.getPhone()+"',phone.primary="+temp.getPhone_pri()+",person="+developerId+" where phone.id="+temp.getId();
			  statement.executeUpdate(create_phone);
			}
		}
	    return statement.executeUpdate(find_person);
	    //return developerId;

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
 default int deleteDeveloper(int developerId) {
	 Statement statement;
	 try {
			statement = Connection.getConnection().createStatement();
			String find_person="delete from developer where developer.id="+developerId;
		    statement.executeUpdate(find_person);
		    find_person="delete from person where person.id="+developerId;
		    return statement.executeUpdate(find_person);
		    //return developerId;

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

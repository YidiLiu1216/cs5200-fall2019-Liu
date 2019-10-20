package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class Person {
   private int id;
   private String firstname;
   private String lastname;
   private String username;
   private String password;
   private String email;
   private String dob="2019-10-18";
   private Collection<User> users=new ArrayList<User>();
   private Collection<Developer> developers=new ArrayList<Developer>();
   private Collection<Phone> phones=new ArrayList<Phone>();
   private Collection<Address> addresses=new ArrayList<Address>();
   public Person(String username){
		this.username=username;
  	}
   public Person(){
		
 	}
   public int getId() {
	   return id;
   }
   public void setId(int id) {
	   this.id=id;
   }
   public String getFirstname() {
	   return firstname;
   }
   public void setFirstname(String firstname) {
	   this.firstname=firstname;
   }
   public String getLastname() {
	   return lastname;
   }
   public void setLastname(String lastname) {
	   this.lastname=lastname;
   }
   public String getUsername() {
	   return username;
   }
   public void setUsername(String username) {
	   this.username=username;
   }
   public String getPassword() {
	   return password;
   }
   public void setPassword(String password) {
	   this.password=password;
   }
   public String getEmail() {
	   return email;
   }
   public void setEmail(String email) {
	   this.email=email;
   }
   public String getDob() {
	   return dob;
   }
   public void setDob(String dob) {
	   this.dob=dob;
   }
   public void addUser(User user) {
	   users.add(user);
   }
   public void removeUser(User user) {
	   users.remove(user);
   }
   public void addDeveloper(Developer developer) {
	   developers.add(developer);
   }
   public void removeDeveloper(Developer developer) {
	   developers.remove(developer);
   }
public Collection<User> getUsers() {
	return users;
}
public void setUsers(Collection<User> users) {
	this.users = users;
}
public Collection<Developer> getDevelopers() {
	return developers;
}
public void setDevelopers(Collection<Developer> developers) {
	this.developers = developers;
}
public Collection<Phone> getPhones() {
	return phones;
}
public void setPhones(Collection<Phone> phones) {
	this.phones = phones;
}
public Collection<Address> getAddress() {
	return addresses;
}
public void setAddress(Collection<Address> addresses) {
	this.addresses = addresses;
}
public void addPhone(Phone phone) {
	   phones.add(phone);
}
public void removePhone(Phone phone) {
	   phones.remove(phone);
}
public void addAddress(Address address) {
	   addresses.add(address);
}
public void removeAddress(Address address) {
	   addresses.remove(address);
}
}

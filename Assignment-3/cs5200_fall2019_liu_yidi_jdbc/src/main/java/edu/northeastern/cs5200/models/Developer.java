package edu.northeastern.cs5200.models;


public class Developer {
  private String developer_key;
  private Person person;
  
  public Developer() {}
  public Developer(String developer_key,int id,String firstname,String lastname) {
	     this.developer_key=developer_key;
	     person=new Person();
		 person.setId(id);
		 person.setFirstname(firstname);
		 person.setLastname(lastname);
  }
  public Developer(String developer_key,int id,String firstname,String lastname,String username,String email,String dob) {
	     this.developer_key=developer_key;
	     person=new Person();
		 person.setId(id);
		 person.setFirstname(firstname);
		 person.setLastname(lastname);
		 person.setUsername(username);
		 person.setEmail(email);
		 person.setDob(dob);
  }
 public Developer(String developer_key,int id,String firstname,String lastname,String username,String email,String dob,String address,String phonenumber) {
	 this.developer_key=developer_key;
     person=new Person();
	 person.setId(id);
	 person.setFirstname(firstname);
	 person.setLastname(lastname);
	 person.setUsername(username);
	 person.setEmail(email);
	 person.setDob(dob);
	 person.addAddress(new Address(address));
	 person.addPhone(new Phone(phonenumber));
  }
  public void setDeveloperkey(String developer_key) {
	  this.developer_key=developer_key;
  }
  public String getDeveloperKey() {
	  return developer_key;
  }
  public void setPerson(Person person) {
		 this.person=person;
	 }
	 public Person getPerson() {
		 return person;
	 }
	public String getDeveloper_Key() {
		return developer_key;
	}
	public void setDeveloper_Key(String developer_key) {
		this.developer_key = developer_key;
	}
	
}

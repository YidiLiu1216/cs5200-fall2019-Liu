package edu.northeastern.cs5200.models;
public class User extends Person {
 private Boolean user_agreement=false;
 private Person person;
 
 public User() {}
 public User(int id,String firstname,String lastname) {
	 person=new Person();
	 person.setId(id);
	 person.setFirstname(firstname);
	 person.setLastname(lastname);	 
 }
 public void setUseragreement(Boolean user_agreement) {
	 this.user_agreement=user_agreement;
 }
 public Boolean getUseragreement() {
	 return user_agreement;
 }
 public void setPerson(Person person) {
	 this.person=person;
 }
 public Person getPerson() {
	 return person;
 }
}

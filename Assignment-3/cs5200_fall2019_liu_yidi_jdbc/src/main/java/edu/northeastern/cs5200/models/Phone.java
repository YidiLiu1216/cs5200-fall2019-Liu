package edu.northeastern.cs5200.models;

public class Phone {
	 private int id;
	 private String phone;
	 private Boolean phone_pri=true;
	 private Person person;
	public Phone() {
		
	}
	public Phone(String phone) {
		this.phone=phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getPhone_pri() {
		return phone_pri;
	}
	public void setPhone_pri(Boolean phone_pri) {
		this.phone_pri = phone_pri;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

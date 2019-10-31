package edu.northeastern.cs5200.controllers;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="faculty")
@DiscriminatorValue(value = "faculty")
public class Faculty extends Person{
  
  private String office;
  private boolean tenured;
  @OneToMany(mappedBy="faculty",fetch=FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  private List<Course>courses;
  public Faculty(){super();}
  public Faculty(String username, String password, String firstname, String lastname, String office,
			Boolean tenured) {
		super(username, password, lastname, firstname);
		this.office = office;
		this.tenured = tenured;
	}
public String getOffice() {
	return office;
}
public void setOffice(String office) {
	this.office = office;
}
public boolean isTenured() {
	return tenured;
}
public void setTenured(boolean tenured) {
	this.tenured = tenured;
}
public List<Course> getCourses() {
	return courses;
}
public void setCourses(List<Course> courses) {
	this.courses = courses;
}


}

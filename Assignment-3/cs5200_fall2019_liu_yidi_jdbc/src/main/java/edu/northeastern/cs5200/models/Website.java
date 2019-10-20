package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Website {
  private int id;
  private String name;
  private String description;
  private String created;
  private String updated;
  private int visits;
  private Collection<Page> pages; 
  public Website(){
	  
  }
  public Website(int id,String name,String description,String created,String updated,int visits){
	  this.id=id;
	  this.name=name;
	  this.description=description;
	  this.created=created;
	  this.updated=updated;
	  this.visits=visits;
  }
  
  public int getId() {
	   return id;
  }
  public void setId(int id) {
	   this.id=id;
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name=name;
  }
  public String getDescription() {
	  return description;
  }
  public void setDescription(String description) {
	  this.description=description;
  }
  public String getCreated() {
	  return created;
  }
  public void setCreated(String created) {
	  this.created=created;
  }
  public String getUpdated() {
	  return updated;
  }

  public int getVisits() {
	return visits;
 }
 public void setVisits(int visits) {
	 this.visits = visits;
 }
 public void setUpdated(String updated) {
	this.updated = updated;
 }
 
 public void addPage(Page page) {
	   pages.add(page);
 }
 public void removePage(Page page) {
	   pages.remove(page);
 }
}

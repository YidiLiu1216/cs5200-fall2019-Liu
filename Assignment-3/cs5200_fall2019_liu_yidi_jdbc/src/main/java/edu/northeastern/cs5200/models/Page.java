package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Page {
  public Page(int id,String title, String description, String created, String updated, int views) {
		super();
		this.id=id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}
 public Page() {
	  
  }
private String title;
  private int id;
  private String description;
  private String created;
  private String updated;
  private int views;
  private Website website;
  private Collection<Widget> widgets;
  
 public int getId() {
	   return id;
 }
 public void setId(int id) {
	   this.id=id;
 }
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCreated() {
	return created;
}
public void setCreated(String created) {
	this.created = created;
}
public String getUpdated() {
	return updated;
}
public void setUpdated(String updated) {
	this.updated = updated;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public Website getWebsite() {
	return website;
}
public void setWebsite(Website website) {
	this.website = website;
}
public Collection<Widget> getWidgets() {
	return widgets;
}
public void setWidgets(Collection<Widget> widgets) {
	this.widgets = widgets;
}
public void addWidget(Widget widget) {
	   widgets.add(widget);
}
public void removeWidget(Widget widget) {
	   widgets.remove(widget);
}
}

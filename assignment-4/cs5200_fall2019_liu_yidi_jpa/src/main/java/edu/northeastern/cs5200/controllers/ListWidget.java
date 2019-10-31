package edu.northeastern.cs5200.controllers;

import javax.persistence.*;

@Entity
public class ListWidget extends Widget {
  private String Items;
  private boolean ordered;
public String getItems() {
	return Items;
}
public void setItems(String items) {
	Items = items;
}
public boolean isOrdered() {
	return ordered;
}
public void setOrdered(boolean ordered) {
	this.ordered = ordered;
}
}

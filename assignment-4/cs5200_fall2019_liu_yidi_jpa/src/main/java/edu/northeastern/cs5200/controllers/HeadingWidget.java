package edu.northeastern.cs5200.controllers;

import javax.persistence.*;

@Entity
public class HeadingWidget extends Widget{
  private int size;

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}
}

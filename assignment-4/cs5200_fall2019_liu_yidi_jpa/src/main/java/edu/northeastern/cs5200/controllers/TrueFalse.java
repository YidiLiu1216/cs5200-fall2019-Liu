package edu.northeastern.cs5200.controllers;

import javax.persistence.*;

@Entity
public class TrueFalse extends Question{
	@Column
	private boolean isTrue;

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}

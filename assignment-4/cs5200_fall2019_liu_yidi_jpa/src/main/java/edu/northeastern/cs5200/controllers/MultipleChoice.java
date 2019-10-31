package edu.northeastern.cs5200.controllers;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MultipleChoice extends Question{
	@Column
	private String choice;
	@Column
	private int correct;
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
}

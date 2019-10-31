package edu.northeastern.cs5200.controllers;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean trueFalseAnswer;
	private int multipleChoiceAnswer;
	@ManyToOne()
	@JsonIgnore
	private Question question;
	@ManyToOne()
	@JsonIgnore
	private Student student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isTrueFalseAnswer() {
		return trueFalseAnswer;
	}
	public void setTrueFalseAnswer(boolean trueFalseAnswer) {
		this.trueFalseAnswer = trueFalseAnswer;
	}
	public int getMultipleChoiceAnswer() {
		return multipleChoiceAnswer;
	}
	public void setMultipleChoiceAnswer(int multipleChoiceAnswer) {
		this.multipleChoiceAnswer = multipleChoiceAnswer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}

package edu.northeastern.cs5200.controllers;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String questions;
	private int points;
	@ManyToOne()
	@JsonIgnore
	private QuizWidget quizwidget;
	@OneToMany()
	private List<Answer> answers;
}

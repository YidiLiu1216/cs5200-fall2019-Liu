package edu.northeastern.cs5200.controllers;

import java.util.List;

import javax.persistence.*;

@Entity
public class QuizWidget extends Widget{
	@OneToMany(mappedBy="quizwidget",fetch=FetchType.EAGER)
	private List<Question> questions;

}

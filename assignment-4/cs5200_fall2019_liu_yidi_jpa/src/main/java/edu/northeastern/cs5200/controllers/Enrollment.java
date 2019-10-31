package edu.northeastern.cs5200.controllers;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Enrollment {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private int grade;
		private String feedback;
		@ManyToOne()
		@JsonIgnore
		private Section section;
		@ManyToOne()
		@JsonIgnore
		private Student student;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		public Section getSection() {
			return section;
		}
		public void setSection(Section section) {
			this.section = section;
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
}

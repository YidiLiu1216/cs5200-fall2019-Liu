package edu.northeastern.cs5200.controllers;

import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity(name="student")
@DiscriminatorValue(value = "student")
public class Student extends Person {

	private int gradYear;
	private long scholarship;
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Enrollment> enrollments;
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Answer> answers;
	public Student(){super();}
	public Student(String username, String password, String firstname,String lastname, int gradYear,
			long scholarship) {
		super(username, password, lastname, firstname);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}
	public int getGradYear() {
		return gradYear;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	public long getScholarship() {
		return scholarship;
	}
	public void setScholarship(long scholarship) {
		this.scholarship = scholarship;
	}
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}

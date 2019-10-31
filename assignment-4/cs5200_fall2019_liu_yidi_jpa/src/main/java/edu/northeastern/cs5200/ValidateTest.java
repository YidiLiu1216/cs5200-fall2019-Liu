package edu.northeastern.cs5200;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.controllers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateTest {
	@Autowired
	UniversityDao u;
	@Test
	public void Validatesusers() {
		List<Person> users = u.findAllUsers();
		System.out.println("user number:"+users.size());
	}
	@Test
	public void Validatesfaculty() {
		List<Faculty> users = u.findAllFaculty();
		System.out.println("facultyn umber:"+users.size());
	}
	@Test
	public void Validatesstudents() {
		List<Student> users = u.findAllStudents();
		System.out.println("student number:"+users.size());
	}
	@Test
	public void Validatescourses() {
		List<Course> users = u.findAllCourses();
		System.out.println("course number:"+users.size());
	}
	@Test
	public void Validatessections () {
		List<Section> users = u.findAllSections();
		System.out.println("section number:"+users.size());
	}
	@Test
	public void ValidatesCourseauthorship () {
		System.out.println("Course authorship:");
		List<Faculty> users = u.findAllFaculty();
		for(Faculty f:users) {
			System.out.println(f.getFirstname()+" "+f.getLastname()+" author"+f.getCourses().size()+" courses");					
		}
	}
	@Test
	public void ValidatesSectionperCourse () {
		System.out.println("Section per course:");
		List<Course> users = u.findAllCourses();
		for(Course c:users) {
			System.out.println(c.getLabel()+" have"+c.getSections().size()+" sections");					
		}
	}
	@Test
	public void ValidatesSectionenrollments() {
		System.out.println("Student per section:");
		List<Section> users = u.findAllSections();
		for(Section s:users) {
			System.out.println(s.getTitle()+" include"+s.getEnrollments().size()+" students");					
		}
	}
	@Test
	public void Validatesstudentenrollments() {
		System.out.println("Section per student:");
		List<Student> users = u.findAllStudents();
		for(Student s:users) {
			System.out.println(s.getFirstname()+" "+s.getLastname()+" enrolls in "+s.getEnrollments().size()+" sections");					
		}
	}
	@Test
	public void ValidatesSectionseats() {
		System.out.println("Seats per section:");
		List<Section> sections = u.findAllSections();
		for(Section s:sections) {
			System.out.printf("Section "+s.getTitle()+"has "+ s.getSeats()+" seats");
		}
	}
}

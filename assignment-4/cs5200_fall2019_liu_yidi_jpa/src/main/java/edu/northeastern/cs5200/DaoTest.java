package edu.northeastern.cs5200;

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
public class DaoTest {
	@Autowired
	private UniversityDao u;
	@Test
	public void Adeletetest() {
	u.truncateDatabase();
	}
	@Test
	public void Bcreatefaculties() {
		Faculty faculty = new Faculty( "alan","1234", "Alan", "Turin", "123A", true);
		u.createFaculty(faculty);
		faculty = new Faculty("ada" , "1234" , "Ada" , "Lovelace", "123B", true);
		u.createFaculty(faculty);	
	}
	@Test
	public void Ccreatestudents() {
		Student student = new Student("alice","1234","Alice","Wonderland", 2020, 12000);
		u.createStudent(student);
		student = new Student("bob","1234","Bob", "Hope", 2021, 23000);
		u.createStudent(student);
		student = new Student("charlie","1234","Charlie", "Brown",  2019, 21000);
		u.createStudent(student);
		student = new Student("dan","1234","Dan", "Craig", 2019, 0);
		u.createStudent(student);
		student = new Student("edward","1234","Edward", "Scissorhands", 2022, 11000);
		u.createStudent(student);
		student = new Student("frank","1234","Frank", "Herbert", 2018, 0);
		u.createStudent(student);
		student = new Student("gregory","1234","Gregory", "Peck", 2023, 10000);
		u.createStudent(student);
	}
	@Test
	public void Dcreatecourses() {
		Course course = new Course("CS1234");
		u.createCourse(course);	
		u.setAuthorForCourse(u.findfacultyByFirstname("Alan"),course);	
		course = new Course("CS2345");
		u.createCourse(course);	
		u.setAuthorForCourse(u.findfacultyByFirstname("Alan"),course);;		
		course = new Course("CS3456");
		u.createCourse(course);	
		u.setAuthorForCourse(u.findfacultyByFirstname("Ada"),course);
		course = new Course("CS4567");
		u.createCourse(course);	
		u.setAuthorForCourse(u.findfacultyByFirstname("Ada"),course);
	}
	@Test
	public void Ecreatesections() {
		Section section = new Section("SEC4321",50);
		Course course = u.findCourseByLabel("CS1234");
		section.setCourse(course);
		u.createSection(section);
		section = new Section("SEC5432",50);
		section.setCourse(u.findCourseByLabel("CS1234"));
		u.createSection(section);
		section = new Section("SEC6543",50);
		section.setCourse(u.findCourseByLabel("CS2345"));
		u.createSection(section);
		section = new Section("SEC7654",50);
		section.setCourse(u.findCourseByLabel("CS3456"));
		u.createSection(section);
	}
	@Test
	public void Fenrollstudent() {
		u.enrollStudentInSection(u.findStudentByFirstname("Alice"), u.findSectionByTitle("SEC4321"));
		u.enrollStudentInSection(u.findStudentByFirstname("Alice"), u.findSectionByTitle("SEC5432"));
		u.enrollStudentInSection(u.findStudentByFirstname("Bob"), u.findSectionByTitle("SEC5432"));
        u.enrollStudentInSection(u.findStudentByFirstname("Charlie"), u.findSectionByTitle("SEC6543"));

	}
}

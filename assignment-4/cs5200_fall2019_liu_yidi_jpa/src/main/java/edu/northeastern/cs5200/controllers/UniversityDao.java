package edu.northeastern.cs5200.controllers;

import java.util.Iterator;
import java.util.List;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UniversityDao {
	@Autowired
	PersonRepository pr;
    @Autowired
	FacultyRepository fr;
    @Autowired
	StudentRepository sr;
	@Autowired
	CourseRepository cr;
    @Autowired
    SectionRepository secr;
	@Autowired
	EnrollmentRepository er;
	private static UniversityDao instance = null;

	public static UniversityDao getInstance() {
		if (instance == null) {
			instance = new UniversityDao();
		}
		return instance;
	}
  public void truncateDatabase() {
	  er.deleteAll();
	  sr.deleteAll();
	  secr.deleteAll();
	  cr.deleteAll();
	  pr.deleteAll();
  }
  public Faculty createFaculty(Faculty faculty) {
	  return fr.save(faculty);
  }
  public Student createStudent(Student student) {
	  return sr.save(student);
  }
  public Course createCourse(Course course) {
	  return cr.save(course);
  }
  public Section createSection(Section section) {
	  return secr.save(section); 
  }
  public Course addSectionToCourse(Section section, Course course) {
	  course.addSection(section);
	  return cr.save(course);
  }
  public Course setAuthorForCourse(Faculty faculty, Course course) {
	  course.setFaculty(faculty);
	  return cr.save(course);
  }
  public  Boolean enrollStudentInSection(Student student, Section section){
	  if (section.getSeats()<1) {
		  return false;
	  }
	  Enrollment enrollment = new Enrollment();
	  enrollment.setStudent(student);
	  enrollment.setSection(section);
	  section.setSeats(section.getSeats()-1);
	  er.save(enrollment);
	  secr.save(section);
	  return true;	
  }
  public  List<Person> findAllUsers() {
	  return (List<Person>) pr.findAll();
  }
  public List<Faculty> findAllFaculty() {
	  return (List<Faculty>) fr.findAll();
  }
  public  List<Student> findAllStudents() {
	  return (List<Student>) sr.findAll(); 
  }
  public List<Course> findAllCourses(){
	  return (List<Course>) cr.findAll();
  } 
  public List<Section> findAllSections() {
	  return (List<Section>) secr.findAll();
  }
  public  List<Course> findCoursesForAuthor(Faculty faculty) {
	  return faculty.getCourses();
  }
  public  List<Section> findSectionForCourse(Course course) {
	  return course.getSections();
  }
  @SuppressWarnings("null")
public List<Student> findStudentsInSection(Section section){
	  Iterator<Enrollment>enrollments=er.findAll().iterator();
	  Enrollment e=new Enrollment();
	  List<Student> sl=null;
	  while (enrollments.hasNext()) {
		  e=enrollments.next();
		  if(e.getSection().getId()==section.getId()) {
			  sl.add(e.getStudent());
		  }
	  }
	  return sl;	  
  }
  @SuppressWarnings("null")
public List<Section> findSectionsForStudent(Student student){
	  Iterator<Enrollment>enrollments=er.findAll().iterator();
	  Enrollment e=new Enrollment();
	  List<Section> secl=null;
	  while (enrollments.hasNext()) {
		  e=enrollments.next();
         if(e.getStudent().getId()==student.getId()) {
        	 secl.add(e.getSection());
		  }
	  }
	  return secl;	
  }
public Faculty findfacultyByFirstname(String firstname) {
	return fr.findByFirstname(firstname);
}
public Course findCourseByLabel(String label) {
	return cr.findByLabel(label);
}
public Student findStudentByFirstname(String firstname) {
	return sr.findStudentByFirstname(firstname);
}
public Section findSectionByTitle(String title) {
	return secr.findByTitle(title);
}
}

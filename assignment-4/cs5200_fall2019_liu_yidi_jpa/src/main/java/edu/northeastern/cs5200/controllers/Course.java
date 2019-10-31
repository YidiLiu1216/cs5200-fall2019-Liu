package edu.northeastern.cs5200.controllers;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	@ManyToOne()
	@JsonIgnore
	private Faculty faculty;
	@OneToMany(mappedBy="course",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
    private List<Section> sections;
	@OneToMany(mappedBy="course",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Module> modules;
	public Course() {}
	public Course(String label) {
		super();
		this.label = label;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public void addSection(Section section) {
		   sections.add(section);
	}
	public void removePhone(Section section) {
		   sections.remove(section);
	}
}

package edu.northeastern.cs5200.controllers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	@Query(value="select * from course as c where c.label=:label", nativeQuery = true)
	public Course findByLabel(@Param("label") String label);
}

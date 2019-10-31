package edu.northeastern.cs5200.controllers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	@Query(value="select * from person as p where p.firstname=:firstname", nativeQuery = true)
	public Student findStudentByFirstname(@Param("firstname") String firstname);
}

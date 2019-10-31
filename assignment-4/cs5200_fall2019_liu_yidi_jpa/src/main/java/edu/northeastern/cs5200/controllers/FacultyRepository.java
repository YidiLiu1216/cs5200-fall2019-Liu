package edu.northeastern.cs5200.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FacultyRepository extends CrudRepository<Faculty, Integer>{
	@Query(value="select * from person as p where p.firstname=:firstname", nativeQuery = true)
	public Faculty findByFirstname(@Param("firstname") String firstname);
}

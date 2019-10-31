package edu.northeastern.cs5200.controllers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SectionRepository extends CrudRepository<Section, Integer>{
	@Query(value="select * from section as s where s.title=:title", nativeQuery = true)
	public Section findByTitle(@Param("title") String title);
}

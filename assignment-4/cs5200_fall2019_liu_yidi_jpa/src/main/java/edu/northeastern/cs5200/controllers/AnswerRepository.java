package edu.northeastern.cs5200.controllers;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer>{
	@Query("delete * from answer")
	public default void deleteAllAnswers() {}
	
}

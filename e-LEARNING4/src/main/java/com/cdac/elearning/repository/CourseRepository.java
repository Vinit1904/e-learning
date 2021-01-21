package com.cdac.elearning.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdac.elearning.model.Course;

public interface CourseRepository extends MongoRepository<Course,ObjectId> {

	@Query("{'name' : ?0}")
	public Course findByName(String name);
	
}

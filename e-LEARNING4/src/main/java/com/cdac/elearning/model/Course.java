package com.cdac.elearning.model;

import java.util.List;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Course")
public class Course {
	
	@Id
	private ObjectId _id;
	
    private String title;
        
	private String image;
	
	private List<Quiz> quiz;  
	
	
	public Course( ) {
		super();

	}



	
    
}

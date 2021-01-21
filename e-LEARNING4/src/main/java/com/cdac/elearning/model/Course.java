package com.cdac.elearning.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Repository
@Document(collection = "Test_Course")
public class Course {
	
	@Id
	private ObjectId id;
	
	@Indexed(name = "index_unique_courseName", unique = true)
	private String name;
	
    private String language;
     
    private String title;
    
	private String image;
	
	@DBRef(db="Quiz")
	private List<Quiz> quiz;
	
	
	public Course( ) {
		super();

	}
	
	
	@PersistenceConstructor
	public Course(ObjectId id, String name, String language, String title, String image) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.title = title;
		this.image = image;
	}



	
	public ObjectId getId() {
		return id;
	}

	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public List<Quiz> getQuiz() {
		return quiz;
	}


	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    
}

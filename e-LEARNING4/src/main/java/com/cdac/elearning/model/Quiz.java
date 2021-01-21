package com.cdac.elearning.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Repository
@Document(collection = "Test_Quiz")
public class Quiz {

	@Id 
	private ObjectId _id;	
	
//	@DBRef(db="Test_Course")
	//private Course Cousrseid;
	
	private String name;
	
	private String question;
	//Type -1/2
	private String correct_answer;
	
	private List<String> incorrect_answers;
	

	public Quiz() {
		super();
	}

	
//	@PersistenceConstructor
//	public Quiz(ObjectId _id,String question, String correct_answer, List<String> incorrect_answers) {
//		super();
//		this._id = _id;
//		this.question=question;
//		this.correct_answer = correct_answer;
//		this.incorrect_answers = incorrect_answers;
//	}



	public ObjectId get_id() {
		return _id;
	}


	

	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public List<String> getIncorrect_answers() {
		return incorrect_answers;
	}

	public void setIncorrect_answers(List<String> incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


//	public Course getCousrseid() {
//		return Cousrseid;
//	}
//
//
//	public void setCousrseid(Course cousrseid) {
//		Cousrseid = cousrseid;
//	}
//


	
	
	
	
}

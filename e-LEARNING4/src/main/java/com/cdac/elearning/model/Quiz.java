package com.cdac.elearning.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Repository
@Document(collection = "Quiz")
public class Quiz {

	@Id 
	private ObjectId _id;
	
	private String language;
	
	private String topic;
	
	private String correct_answer;
	
	private List<String> incorrect_answers;
	

	public Quiz() {
		super();
	}

	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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


	@Override
	public String toString() {
		return "quiz [_id=" + _id + ", language=" + language + ", topic=" + topic + ", correct_answer=" + correct_answer
				+ ", incorrect_answers=" + incorrect_answers + "]";
	}
	
	
	
}

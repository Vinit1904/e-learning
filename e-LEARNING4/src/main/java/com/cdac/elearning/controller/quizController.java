package com.cdac.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.elearning.dto.Status;
import com.cdac.elearning.dto.Status.StatusType;
import com.cdac.elearning.exception.CourseException;
import com.cdac.elearning.model.Course;
import com.cdac.elearning.model.Quiz;
import com.cdac.elearning.service.QuizService;

@RestController
@CrossOrigin
public class quizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("/quiz/add")
	public Status addQuiz(@RequestBody Quiz quiz) {
		try {
			quizService.addQuiz(quiz);
			Status status=new Status();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Course Successfully Entered!!");
			return status; 
			
		}
		catch(DuplicateKeyException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		catch(CourseException e) {
			Status status=new Status();
			status.setStatus(StatusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
}

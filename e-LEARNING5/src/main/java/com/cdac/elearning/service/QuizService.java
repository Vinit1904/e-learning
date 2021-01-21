package com.cdac.elearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cdac.elearning.exception.CourseException;
import com.cdac.elearning.model.Course;
import com.cdac.elearning.model.Quiz;
import com.cdac.elearning.repository.CourseRepository;
import com.cdac.elearning.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository quizRepository;

	@Autowired
	CourseRepository courseRepository; 
	
	public void addQuiz(Quiz quiz)
	{
		System.out.print(quiz);
		try {
			Course course=courseRepository.findByName("cpp");
			
			List<Quiz> mquiz =quizRepository.getQuizByName("cpp");
			System.out.println();
			System.out.println(mquiz);
			mquiz.add(quiz);
			course.setQuiz(mquiz);
			//quiz.setCousrseid(course);
			
			
			quizRepository.save(quiz);
			courseRepository.save(course);
		}
		catch(DuplicateKeyException e) {
			throw new CourseException(e.getMessage());
		}
		catch(CourseException e){
			throw new CourseException("Duplicate Course Name");
		}						
		
	}
	
	public void findByName(Quiz quiz)
	{
		System.out.print(quiz);
		try {
			Course course=courseRepository.findByName("cpp");
			List<Quiz> mquiz =course.getQuiz();
			mquiz.add(quiz);
			course.setQuiz(mquiz);
//			quiz.setCousrseid(course);
//			
			quizRepository.save(quiz);
//			courseRepository.save(course);
		}
		catch(DuplicateKeyException e) {
			throw new CourseException(e.getMessage());
		}
		catch(CourseException e){
			throw new CourseException("Duplicate Course Name");
		}						
		
	}
}

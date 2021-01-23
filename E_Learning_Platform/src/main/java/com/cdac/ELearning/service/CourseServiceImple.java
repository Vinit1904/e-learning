package com.cdac.ELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.ELearning.model.Course;
import com.cdac.ELearning.model.Problem;
import com.cdac.ELearning.model.Quiz;
import com.cdac.ELearning.repository.CourseRepository;

@Service
public class CourseServiceImple implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    
    
    
    @Override
    public void addQuiz(List<Quiz> quiz,String courseName) {

        Course course = courseRepository.findByCourseName(courseName);
        
        System.out.println();
        System.out.println(course.getQuiz());
        course.getQuiz().addAll(quiz);

        courseRepository.save(course);
    }

    @Override
    public void addProblem(Problem problem, String courseName) {

        Course course = this.courseRepository.findByCourseName(courseName);

        course.getProblem().add(problem);

        this.courseRepository.save(course);
    }

    @Override
    public void addQuizScore(String courseName, String score) {
        Course course = this.courseRepository.findByCourseName(courseName);
        course.getScore().setQuizScore(score);
        this.courseRepository.save(course);
    }

    @Override
    public void addCourse(Course course) {

        this.courseRepository.insert(course);
    }

    @Override
    public List<Course> fetchAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

	
}


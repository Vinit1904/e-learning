package com.cdac.ELearning.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.ELearning.model.Quiz;
import com.cdac.ELearning.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
   CourseService courseService;

    @PostMapping("/add/{name}")
    public void addQuiz(@RequestBody List<Quiz> quiz, @PathVariable String name){

        courseService.addQuiz(quiz,name);
    }

    @PostMapping("/score/{name}")
    public void addQuizScore(@PathVariable String name,@RequestBody String score){

        courseService.addQuizScore(name,score);
    }

}

package com.cdac.ELearning.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.ELearning.model.Problem;
import com.cdac.ELearning.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    CourseService courseService;

    @PostMapping("/add/{courseName}")
    public String addProblem(@RequestBody Problem problem, @PathVariable String courseName){

        this.courseService.addProblem(problem,courseName);
        
        return "Success";
    }
}


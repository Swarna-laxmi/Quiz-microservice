package com.sb.quizapp.controller;

import com.sb.quizapp.model.Question;
import com.sb.quizapp.service.QuestionService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions()
    {
        return service.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        return service.getByCategory(category);
    }
}

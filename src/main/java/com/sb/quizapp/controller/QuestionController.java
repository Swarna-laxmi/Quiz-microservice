package com.sb.quizapp.controller;

import com.sb.quizapp.model.Question;
import com.sb.quizapp.service.QuestionService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question)
    {
      return  service.addQuestion(question);

    }

    @PutMapping("updateQuestion/{id}")
    public String updateQuestionById(@PathVariable Long id, @RequestBody Question question)
    {
        if(question.getId()==null || !question.getId().equals(id))
            return  "ID in path and request body must match";
       else return service.updateQuestionById(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String deleteQuestionById(@PathVariable Long id){

        return service.deleteQuestionById(id);
    }
}

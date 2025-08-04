package com.sb.quizapp.service;

import com.sb.quizapp.dao.QuestionDao;
import com.sb.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao repo;

    public List<Question> getAllQuestions()
    {
       return repo.findAll();
    }


    public List<Question> getByCategory(String category) {
        return repo.findByCategory(category);
    }
}




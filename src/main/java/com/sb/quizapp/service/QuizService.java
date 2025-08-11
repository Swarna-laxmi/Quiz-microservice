package com.sb.quizapp.service;

import com.sb.quizapp.dao.QuestionDao;
import com.sb.quizapp.dao.QuizDao;
import com.sb.quizapp.model.Question;
import com.sb.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    
    @Autowired
    private QuizDao quizRepo;

    @Autowired
    private QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions= questionDao.findQuestionByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }
}

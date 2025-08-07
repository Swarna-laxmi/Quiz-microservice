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

    public String addQuestion(Question question) {
         repo.save(question);
         return "success";
    }

    public String updateQuestionById(Question question) {
       /* Question  q=new Question();
        q.setCategory(question.getCategory());
        q.setDifficultyLevel(question.getDifficultyLevel());
        q.setQuestionText(question.getQuestionText());
        q.setOption_A(question.getOption_A());
        q.setOption_B(question.getOption_B());
        q.setOption_C(question.getOption_C());
        q.setOption_D(question.getOption_D());
        q.setCorrectAnswer(question.getCorrectAnswer());*/
        repo.save(question);
        return "updated";
    }

    public String deleteQuestionById(Long id) {
        if (!repo.existsById(id)) {
            return "Question not found";
        }
        repo.deleteById(id);
        return "Question with ID " + id + " deleted successfully";
    }
}





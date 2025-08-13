package com.sb.quizapp.service;

import com.sb.quizapp.dao.QuestionDao;
import com.sb.quizapp.dao.QuizDao;
import com.sb.quizapp.model.Question;
import com.sb.quizapp.model.QuestionWrapper;
import com.sb.quizapp.model.Quiz;
import com.sb.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
      Optional<Quiz> quiz=  quizRepo.findById(id);
      List<Question> questionFromDB= quiz.get().getQuestions();
      List<QuestionWrapper> questionForUser= new ArrayList<>();
        for (Question q : questionFromDB) {
            QuestionWrapper qw = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionText(),
                    q.getOption_A(),
                    q.getOption_B(),
                    q.getOption_C(),
                    q.getOption_D()
            );
            questionForUser.add(qw);
        }
      return new ResponseEntity<> (questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
        Quiz quiz= quizRepo.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int index=0;
        for(Response r: responses)

            if(r.getResponse().equals(questions.get(index).getCorrectAnswer())) {

                right++;
                index++;
            }


       /* for (int i = 0; i < responses.size(); i++) {
            String userAnswer = responses.get(i).getResponse();
            String correctAnswer = questions.get(i).getCorrectAnswer();

            if (userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
                right++;
            }
        }*/

        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}

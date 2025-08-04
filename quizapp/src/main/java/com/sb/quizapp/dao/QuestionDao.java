package com.sb.quizapp.dao;

import com.sb.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Long> {
    List<Question> findByCategory(String category);
}

package com.sb.quizapp.dao;

import com.sb.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Long> {
    List<Question> findByCategory(String category);


   @Query(value ="SELECT * FROM (\n" +
           "        SELECT * FROM question WHERE category = :category ORDER BY DBMS_RANDOM.VALUE\n" +
           "    ) WHERE ROWNUM <= :numQ", nativeQuery = true)
   List<Question> findQuestionByCategory(String category, int numQ);


}

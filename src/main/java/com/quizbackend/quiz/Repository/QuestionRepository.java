package com.quizbackend.quiz.Repository;

import com.quizbackend.quiz.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    // JPQL query to fetch questions by category
    @Query("SELECT q FROM Question q WHERE q.category = :category")
    List<Question> findQuestionsByCategory(@Param("category") String category);


    // JPQL query to fetch question by id
    @Query("SELECT q FROM Question q WHERE q.id = :id")
    Question findQuestionById(@Param("id")int id);








    // this query was for the Quiz Controller create method that need to slect random question fgrom the
    // quiz table

    @Query(value = "SELECT * FROM Question q WHERE q.category = :category ORDER BY q.id LIMIT :numOfQ", nativeQuery = true)
    List<Question> getRandomQuestionByCategory(String category, int numOfQ);




}

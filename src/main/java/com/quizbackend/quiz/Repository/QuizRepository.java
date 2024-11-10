package com.quizbackend.quiz.Repository;

import com.quizbackend.quiz.Model.Question;
import com.quizbackend.quiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {


    @Query("SELECT q FROM Quiz q WHERE q.quizId= :id")
    List<Question> findAllById(int id);
}

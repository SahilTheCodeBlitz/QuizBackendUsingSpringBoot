package com.quizbackend.quiz.Model;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer quizId;

    String quizTitle;

    @ManyToMany
    List<Question> quizQuestion;

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", quizTitle='" + quizTitle + '\'' +
                ", quizQuestion=" + quizQuestion +
                '}';
    }

    public Quiz(){
        // non - parameirized constructor

    }

    public Quiz( String quizTitle, List<Question> quizQuestion) {
//        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.quizQuestion = quizQuestion;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public List<Question> getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(List<Question> quizQuestion) {
        this.quizQuestion = quizQuestion;
    }
    // here question will be refereed from quiz table
    // many to many means many question can be present in many quiz


}

package com.quizbackend.quiz.Controller;


import com.quizbackend.quiz.Model.QuestionResponse;
import com.quizbackend.quiz.Model.QuestionWrapper;
import com.quizbackend.quiz.Service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    // jobs of the quiz controller

    // 1) create the quiz
    // 2) fetch the created quiz questions

    //controller for creating the quiz

    @GetMapping("createQuiz")
    public String createQuiz(@RequestParam String category,@RequestParam int numOfQ , @RequestParam String title){

        return quizService.createQuiz(category,numOfQ,title);

    }


    // controller for getting the quiz question
    // we will get by quizid
    @GetMapping("getQuestion/{quizId}")
    public List<QuestionWrapper> getQuiz(@PathVariable int quizId){
        return quizService.getQuizQuestionList(quizId);
    }

    // controller for calculating the  quiz scores
    // as a response we will get question id and right answer plus the quiz id
    // quiz id se w can obtain all questions and then wqe will copare

    @PostMapping("submit/{quizId}")
    public Integer getScore(@PathVariable int quizId, @RequestBody List<QuestionResponse> questionResponse){
        return quizService.calculateScore(quizId,questionResponse);
    }
}

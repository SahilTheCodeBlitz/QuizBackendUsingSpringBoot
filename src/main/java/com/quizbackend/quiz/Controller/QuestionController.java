package com.quizbackend.quiz.Controller;

import com.quizbackend.quiz.Model.Question;
import com.quizbackend.quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {


    // controller for getting all the question stored  in the database
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    // controller for getting question by category
    @GetMapping("/question/{category}")
    public List<Question> getQuestion(@PathVariable String category){
        return questionService.getQuestionByCategory(category.toLowerCase());
    }

    // controller for adding the question

    @PostMapping("/question")
    public String addQuestion(@RequestBody Question data){
        return questionService.addQuestion(data);
    }

    // controller for updating the question

    @PutMapping("/question/{id}")
    public Question updateQuestionByID(@PathVariable int id,@RequestBody Question data){

        // getting the question
        // if found update it
        // save it


        return questionService.updateQuestion(id,data);

    }

    // controller for deleting the question
    @DeleteMapping("question/{id}")
    public String deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

}

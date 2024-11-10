package com.quizbackend.quiz.Service;

import com.quizbackend.quiz.Model.Question;
import com.quizbackend.quiz.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    //getting all questions stored in database
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }


    // getting question by category
    public List<Question> getQuestionByCategory(String category){
        return questionRepository.findQuestionsByCategory(category);
    }


    // method for adding the data to the database

    public String addQuestion(Question question){
        questionRepository.save(question);
        return "Success";
    }

    public Question updateQuestion(int id,Question data) {

        Question existingQuestion = questionRepository.findQuestionById(id);


        // Update fields
        existingQuestion.setQuestionTitle(data.getQuestionTitle());
        existingQuestion.setOption1(data.getOption1());
        existingQuestion.setOption2(data.getOption2());
        existingQuestion.setOption3(data.getOption3());
        existingQuestion.setOption4(data.getOption4());
        existingQuestion.setRightAnswer(data.getRightAnswer());
        existingQuestion.setDifficultyLevel(data.getDifficultyLevel());
        existingQuestion.setCategory(data.getCategory());

        return questionRepository.save(existingQuestion);

    }

    public String deleteQuestion(int id){
        Question question = questionRepository.findQuestionById(id);
        questionRepository.delete(question);
        return "Success";
    }
}

package com.quizbackend.quiz.Service;

import com.quizbackend.quiz.Model.Question;
import com.quizbackend.quiz.Model.QuestionResponse;
import com.quizbackend.quiz.Model.QuestionWrapper;
import com.quizbackend.quiz.Model.Quiz;
import com.quizbackend.quiz.Repository.QuestionRepository;
import com.quizbackend.quiz.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    // we require this question repository for fetching the question


    public String createQuiz(String category, int numOfQ, String title) {

        // select random 5 question from the Question whose cateogry is java

        String categoryLowerCase = category.toLowerCase();

        List<Question> quizQuestion = questionRepository.getRandomQuestionByCategory(categoryLowerCase,numOfQ);

        System.out.println("Quiz question = "+quizQuestion);
        System.out.println("Category = "+category);
        System.out.println("title = "+title);
        // now we are list of 5 questions

        // saving it to Quiz db

//        Quiz quiz = new Quiz(title,quizQuestion);

        // or

        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuizQuestion(quizQuestion);


        quizRepository.save(quiz);


        return "sucess";



    }

    public List<QuestionWrapper> getQuizQuestionList(int id) {

        Optional<Quiz> quiz = quizRepository.findById(id); // will return list of  quiz data having that id

        System.out.println("Quiz = "+quiz);

        // now we have id of the questions in the quiz in list
        // fetch question now

        List<Question> question = quiz.get().getQuizQuestion(); // wheenever used optional; you have top use
        // .get()

        System.out.println("question = "+question);


        // List of object having type of wrapper class
        List<QuestionWrapper> questionWrapperList = new ArrayList<>();

        for(Question q : question){

            // object of wrapper class

            QuestionWrapper qw = new QuestionWrapper();

            qw.setQuestionTitle(q.getQuestionTitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            qw.setDifficultyLevel(q.getDifficultyLevel());
            qw.setCategory(q.getCategory());


            // adding this object to array list

            questionWrapperList.add(qw);

        }
        return questionWrapperList;
    }

    public Integer calculateScore(int quizId, List<QuestionResponse> questionResponse) {

        //  getting question bu using quiz id
        Optional<Quiz> quiz = quizRepository.findById(quizId);

        // getting all question

        List<Question> quizQuestions = quiz.get().getQuizQuestion();

        int res = 0;
        int  i = 0;

        for (Question q : quizQuestions){
            if(q.getRightAnswer().equals(questionResponse.get(i).getResponse())){
                res++;
            }
            i++;
        }

        return res;
    }
}

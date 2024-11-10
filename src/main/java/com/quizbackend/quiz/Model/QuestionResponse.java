package com.quizbackend.quiz.Model;

public class QuestionResponse {

    private Integer quizId;

    private String response ;

    public QuestionResponse(){
        // non parametirized connstructor
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "quizId=" + quizId +
                ", response='" + response + '\'' +
                '}';
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public QuestionResponse(int quizId, String response) {
        this.quizId = quizId;
        this.response = response;
    }

}

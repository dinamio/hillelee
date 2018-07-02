package service.builder;

import entity.Quiz;

import java.util.ArrayList;
import java.util.List;

public class StatisticBuilder {

    private Quiz quiz;
    private List<Boolean> userAnswers = new ArrayList<>();

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Boolean> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Boolean> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public void addAnswer(Boolean answer){
        this.userAnswers.add(answer);
    }

    public void clear(){
        this.quiz = null;
        this.userAnswers.clear();
    }
}

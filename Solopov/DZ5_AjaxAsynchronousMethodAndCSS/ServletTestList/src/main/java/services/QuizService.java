package services;

import entity.Question;
import entity.Quiz;

import java.util.Set;

public class QuizService {


    public boolean removeQuestion(Set<Quiz> quizSet, int id) {
        Quiz quiz = null;
        for (Quiz currQuiz : quizSet)
            if (currQuiz.getId() == id) {
                quiz = currQuiz;
                break;
            }
        return quizSet.remove(quiz);
    }


}

package service;

import model.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuizService {
    Quiz currentQuiz;

    public boolean removeQuestion(Set<Quiz> quizSet, int id) {
        Quiz quiz = null;
        for (Quiz currQuiz : quizSet)
            if (currQuiz.getId() == id) {
                quiz = currQuiz;
                break;
            }
        return quizSet.remove(quiz);
    }

    public Quiz getCurrentQuiz() {
        return currentQuiz;
    }

    public void setCurrentQuiz(Quiz currentQuiz) {
        this.currentQuiz = currentQuiz;
    }
}

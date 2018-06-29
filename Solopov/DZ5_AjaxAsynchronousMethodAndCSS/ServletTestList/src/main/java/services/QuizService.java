package services;

import hibernate.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

@Service
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

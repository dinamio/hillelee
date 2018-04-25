package service;

import model.Quiz;

import java.util.*;
import java.util.function.Predicate;

public class QuizAdder {
    private List<Quiz> quizList;

    public boolean addQuiz(Quiz quiz) {
        Objects.requireNonNull(quiz);
        if (quizList == null) {
            quizList = new LinkedList<>();
        }
        return quizList.add(quiz);
    }

    public List<Quiz> viewQuiz() {
        return Collections.unmodifiableList(quizList);
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public boolean deleteQuiz(Quiz quiz) {
        Optional<Quiz> optionalQuiz = quizList.stream().filter(Predicate.isEqual(quiz)).findFirst();
        if (optionalQuiz.isPresent()) {
            Quiz toRemove = optionalQuiz.get();
            return quizList.remove(toRemove);
        }
        return false;
    }
}

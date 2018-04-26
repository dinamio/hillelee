package service;

import model.Quiz;

import java.util.*;
import java.util.function.Predicate;

public class QuizService {
    private List<Quiz> quizList;
    private static volatile QuizService instance;

    private QuizService() {
        this.quizList = new ArrayList<>();
    }

    public static QuizService getInstance() {
        QuizService localInstance = instance;
        if (localInstance == null) {
            synchronized (QuizService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new QuizService();
                }
            }
        }
        return localInstance;
    }

    public boolean addQuiz(Quiz quiz) {
        Objects.requireNonNull(quiz);
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
            return quizList.remove(optionalQuiz.get());
        }
        return false;
    }

    public boolean deleteQuiz(int id) {
        Optional<Quiz> optionalQuiz = quizList.stream().filter(quiz -> quiz.getId() == id).findFirst();
        if (optionalQuiz.isPresent()) {
            return quizList.remove(optionalQuiz.get());
        }
        return false;
    }

    public void deleteQuiz(int[] id) {
        for(int i: id) deleteQuiz(i);
    }

}

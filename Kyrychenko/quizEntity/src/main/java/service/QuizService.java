package service;

import dao.QuizDao;
import dao.impl.QuizDaoImpl;
import model.Quiz;

import java.util.List;
import java.util.Objects;

public class QuizService {
    private QuizDao quizDao;

    private QuizService() {
        this.quizDao = new QuizDaoImpl();
    }

    private static class QuizServiceHolder {
        private static final QuizService instance = new QuizService();
    }

    public static QuizService getInstance() {
        return QuizServiceHolder.instance;
    }

    public boolean addQuiz(Quiz quiz) {
        Objects.requireNonNull(quiz);
        return quizDao.addQuiz(quiz);
    }

    public List<Quiz> getQuizList() {
        return quizDao.getQuizList();
    }

    public boolean update(Quiz quiz) {
        return quizDao.update(quiz);
    }

    public boolean deleteQuiz(int id) {
        return quizDao.deleteQuiz(id);
    }

}

package service;

import dao.QuizDao;
import model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;

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

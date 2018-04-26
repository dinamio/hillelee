package borysov.service;

import borysov.entity.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizService {

    static List<Quiz> listOfQuizzes = new ArrayList<Quiz>();

    static {

        Quiz quiz1 = new Quiz("география", "города", "alex");
        Quiz quiz2 = new Quiz("literature", "novels", "den");
        listOfQuizzes.add(quiz1);
        listOfQuizzes.add(quiz2);
    }

    public List<Quiz> getListOfQuizzes() {
        return listOfQuizzes;
    }


    public void addQuiz(Quiz quiz) {
        listOfQuizzes.add(quiz);
    }

    public void removeQuizById(int id) {
        listOfQuizzes.remove(id);
    }
}

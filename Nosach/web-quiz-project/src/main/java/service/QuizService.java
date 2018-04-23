package service;

import entity.Quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuizService {

    public static final QuizService QUIZ_SERVICE = new QuizService();

    private QuizService() {
    }

    private  List<Quiz> quizzes = new ArrayList<>();

    public void addQuiz (String subject, String theme, String author){
        quizzes.add(new Quiz(subject, theme, author));
    }

    public List getQuizList (){
        return quizzes;
    }

    public void removeQuiz (int id){
        quizzes = quizzes.stream().filter(test -> !(test.getId()==id)).collect(Collectors.toList());
    }

}

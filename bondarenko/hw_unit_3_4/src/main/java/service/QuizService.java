package service;

import model.Quiz;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class QuizService {

    private static Map<String, Quiz> quizzes = new ConcurrentHashMap<>();

    static {
        quizzes.put("test", new Quiz("test", "test"));
        quizzes.put("test1", new Quiz("test1", "test1"));
    }

    public Quiz add(Quiz quiz){
        return quizzes.put(quiz.getName(), quiz);
    }

    public Quiz remove(String name){
        return quizzes.remove(name);
    }

    public Collection<Quiz> getAll(){
        return quizzes.entrySet()
                      .stream()
                      .map(Map.Entry::getValue)
                      .collect(Collectors.toList());
    }

    public Object get(String name) {
        return quizzes.get(name);
    }
}

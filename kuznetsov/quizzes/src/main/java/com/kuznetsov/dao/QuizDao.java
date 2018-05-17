package dao;

import enteties.SubjectQuiz;

import java.util.List;

public interface QuizDao {
    List<SubjectQuiz> getAllQuizzes();

    void insert(SubjectQuiz quiz);
}

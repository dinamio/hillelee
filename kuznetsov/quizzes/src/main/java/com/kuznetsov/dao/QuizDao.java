package dao;

import enteties.SubjectQuiz;

import java.util.List;

public interface QuizDao {

    List<SubjectQuiz> getAllQuizzesFromDB();

    void removeQuizFromDB(int id);

    void addNewQuizToDB(SubjectQuiz quiz);

}

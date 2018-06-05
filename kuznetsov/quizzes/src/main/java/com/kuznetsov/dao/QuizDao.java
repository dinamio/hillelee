package com.kuznetsov.dao;

import com.kuznetsov.entities.SubjectQuiz;

import java.util.List;

public interface QuizDao {

    List<SubjectQuiz> getAllQuizzesFromDB();

    void removeQuizFromDB(int id);

    void addNewQuizToDB(SubjectQuiz quiz);

}

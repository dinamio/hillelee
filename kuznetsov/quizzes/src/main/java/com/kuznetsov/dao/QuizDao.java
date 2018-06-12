package com.kuznetsov.dao;

import com.kuznetsov.entities.Quizzes;

import java.util.List;

public interface QuizDao {

    List<Quizzes> getAllQuizzesFromDB();

    void removeQuizFromDB(int id);

   void addNewQuizToDB(Quizzes quiz);

}

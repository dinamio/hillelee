package com.kuznetsov.dao;

import com.kuznetsov.entities.QuizzesEntity;

import java.util.List;

public interface QuizDao {

    List<QuizzesEntity> getAllQuizzesFromDB();

    void removeQuizFromDB(int id);

//    void addNewQuizToDB(SubjectQuiz quiz);

}

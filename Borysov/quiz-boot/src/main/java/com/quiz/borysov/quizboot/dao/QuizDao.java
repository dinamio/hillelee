package com.quiz.borysov.quizboot.dao;

import com.quiz.borysov.quizboot.entity.Answer;
import com.quiz.borysov.quizboot.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface QuizDao extends CrudRepository<Quiz,Integer> {
}


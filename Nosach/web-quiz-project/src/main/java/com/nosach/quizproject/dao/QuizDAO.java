package com.nosach.quizproject.dao;

import com.nosach.quizproject.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDAO extends CrudRepository<Quiz, Integer> {

}

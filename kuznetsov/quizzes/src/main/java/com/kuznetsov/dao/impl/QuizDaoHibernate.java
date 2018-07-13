package com.kuznetsov.dao.impl;

import com.kuznetsov.dao.QuizDao;
import com.kuznetsov.entities.Quizzes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizDaoHibernate implements QuizDao {
    private final Session session;

    @Autowired
    public QuizDaoHibernate(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public List<Quizzes> getAllQuizzesFromDB() {

        Query query = session.createQuery("from " + Quizzes.class.getName());
        return query.list();
    }

    @Override
    public void addNewQuizToDB(Quizzes quiz) {

        Transaction transaction = session.beginTransaction();
        session.save(quiz);
        transaction.commit();
    }

    @Override
    public void removeQuizFromDB(int id) {

        Transaction transaction = session.beginTransaction();
        Quizzes quiz = session.find(Quizzes.class, id);
        session.remove(quiz);
        transaction.commit();
    }
}


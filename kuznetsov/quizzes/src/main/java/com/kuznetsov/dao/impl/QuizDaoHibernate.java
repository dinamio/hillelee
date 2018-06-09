package com.kuznetsov.dao.impl;

import com.kuznetsov.dao.QuizDao;
import com.kuznetsov.entities.Quizzes;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizDaoHibernate implements QuizDao {

    @Override
    public List<Quizzes> getAllQuizzesFromDB() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + Quizzes.class.getName());
        return query.list();
    }

    @Override
    public void addNewQuizToDB(Quizzes quiz) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(quiz);
        transaction.commit();
    }

    @Override
    public void removeQuizFromDB(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Quizzes quiz = session.find(Quizzes.class, id);
        session.remove(quiz);
        transaction.commit();
    }
}


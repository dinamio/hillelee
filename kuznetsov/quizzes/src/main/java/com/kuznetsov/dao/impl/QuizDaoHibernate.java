package com.kuznetsov.dao.impl;


import com.kuznetsov.dao.QuizDao;
import com.kuznetsov.entities.QuizzesEntity;
import com.kuznetsov.entities.UserDataFromLoginJSP;
import com.kuznetsov.entities.UsersEntity;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class QuizDaoHibernate implements QuizDao {
    private Logger logger = Logger.getLogger(getClass().getName());


    public List<QuizzesEntity> getAllQuizzesFromDB() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + QuizzesEntity.class.getName());
        return query.list();
    }


    public void addNewQuizToDB(QuizzesEntity quiz) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(quiz);
    }


    @Override
    public void removeQuizFromDB(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        QuizzesEntity quiz = session.find(QuizzesEntity.class, id);
        session.remove(quiz);
        transaction.commit();
    }

    public boolean isCredentialsEqual(UserDataFromLoginJSP userDataFromLoginJSP) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select " + userDataFromLoginJSP);
        if (query.list().size() > 0) return true;
        return false;
    }

    public UsersEntity getUserFromDB(String sessionLogin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UsersEntity usersEntity = session.byNaturalId(UsersEntity.class).using("login", sessionLogin).load();
        transaction.commit();
        return usersEntity;
    }

    public void saveCredentialsToDB(UsersEntity usersEntity) {
        System.err.println(usersEntity.toString());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usersEntity);
        transaction.commit();

    }
}


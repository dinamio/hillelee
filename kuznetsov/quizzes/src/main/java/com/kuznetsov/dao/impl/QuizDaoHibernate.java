package com.kuznetsov.dao.impl;


import com.kuznetsov.dao.QuizDao;
import com.kuznetsov.entities.*;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class QuizDaoHibernate implements QuizDao {
    private Logger logger = Logger.getLogger(getClass().getName());


    public List<QuizzesEntity> getAllQuizzesFromDB() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + QuizzesEntity.class.getName());
        return query.list();
    }

    public SubjectsEntity getSubjectIdFromDb(String subject){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        SubjectsEntity subjectsEntity = session.byNaturalId(SubjectsEntity.class).using("subject", subject).load();
        transaction.commit();
        return subjectsEntity;
    }

    public Integer addThemeToBd(ThemesEntity themesEntity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(themesEntity);
        transaction.commit();
        return themesEntity.getId();
    }


    public void addNewQuizToDB(QuizzesEntity quiz) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(quiz);
        transaction.commit();
    }


    @Override
    public void removeQuizFromDB(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        QuizzesEntity quiz = session.find(QuizzesEntity.class, id);
        session.remove(quiz);
        transaction.commit();
    }


    public UsersEntity getUserFromDB(String sessionLogin) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UsersEntity usersEntity = session.byNaturalId(UsersEntity.class).using("login", sessionLogin).load();
        transaction.commit();

        return usersEntity;
    }

    public void saveCredentialsToDB(UsersEntity usersEntity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usersEntity);
        transaction.commit();

    }

    public void addQuestionsToBd(Integer themeId, Map<String, Byte> questionMap) {

        for(Map.Entry<String, Byte> entry : questionMap.entrySet()){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
        session.save(new QuestionsEntity(themeId, entry.getKey(), entry.getValue()));
        transaction.commit();
        }
    }
}


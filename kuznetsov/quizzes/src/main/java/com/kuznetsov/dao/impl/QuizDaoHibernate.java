package com.kuznetsov.dao.impl;


import com.kuznetsov.dao.QuizDao;
import com.kuznetsov.entities.*;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

@Component
public class QuizDaoHibernate implements QuizDao {
    private Logger logger = Logger.getLogger(getClass().getName());


    public List<QuizzesEntity> getAllQuizzesFromDB() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + QuizzesEntity.class.getName());
        return query.list();
    }

    public SubjectsEntity getSubjectsFromDb(String subject){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        SubjectsEntity subjectsEntity = session.byNaturalId(SubjectsEntity.class).using("subject", subject).load();
        transaction.commit();
        return subjectsEntity;
    }

    public SubjectsEntity getSubjectsFromDb(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        SubjectsEntity subjectsEntity = session.get(SubjectsEntity.class, id);
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

    public UsersEntity getUserFromDB(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UsersEntity usersEntity = session.get(UsersEntity.class, id);
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

    public ThemesEntity getThemeFromDb(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ThemesEntity themesEntity = session.get(ThemesEntity.class, id);
        transaction.commit();

        return themesEntity;
    }

    public Map<String, Byte> getQuestionsFromDB(Integer themeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<QuestionsEntity> questionsEntities = new ArrayList<>();
        Map<String, Byte> questions = new HashMap<>();

        String hql = "from QuestionsEntity where themeId = :userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", themeId);
        questionsEntities = query.list();

        for(int i = 0; i < questionsEntities.size(); i++) {
            QuestionsEntity entry = questionsEntities.get(i);
            questions.put(entry.getQuestion(), entry.getAnswer());
        }
        return questions;


    }

    public QuizzesEntity getIdFromDb(Integer id) {
        return null;
    }
}


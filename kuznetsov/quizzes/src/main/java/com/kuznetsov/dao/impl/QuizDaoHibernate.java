package com.kuznetsov.dao.impl;

import com.kuznetsov.dao.Connector;
import com.kuznetsov.dao.QuizDao;
import com.kuznetsov.dao.impl.services.DataBaseAdapter;
import com.kuznetsov.dao.impl.services.QuestionsDB;
import com.kuznetsov.dao.impl.services.UsersDB;
import com.kuznetsov.entities.SubjectQuiz;
import com.kuznetsov.entities.UserDataFromLoginJSP;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class QuizDaoHibernate implements QuizDao {
    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private DataBaseAdapter subjectsDB;
    @Autowired
    private DataBaseAdapter themesDB;
    @Autowired
    private UsersDB usersDB;
    @Autowired
    private QuestionsDB questionsDB;


    public List<SubjectQuiz> getAllQuizzesFromDB() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from " + SubjectQuiz.class.getName());
        return query.list();
    }

    @Override
    public void addNewQuizToDB(SubjectQuiz quiz) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(quiz);
    }


    @Override
    public void removeQuizFromDB(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        SubjectQuiz quiz = session.find(SubjectQuiz.class, id);
        session.remove(quiz);
        transaction.commit();
    }

    public boolean isCredentialsEqual(UserDataFromLoginJSP userDataFromLoginJSP) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select " + userDataFromLoginJSP);
        if (query.list().size() > 0) return true;
        return false;
    }

    public boolean isUserExistInDB(String sessionLogin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select " + sessionLogin);
        if (query.list().size() > 0) return true;
        return false;
    }

    public String getSalt(String login) {
        return usersDB.getSalt(login);
    }

    public void saveCredentialsToDB(String login, String pwd, String salt) {

        PreparedStatement statement;

        try {
            statement = Connector.getConnection().prepareStatement("INSERT into Users(login, pwd, salt) VALUES (?,?,?)");

            statement.setString(1, login);
            statement.setString(2, pwd);
            statement.setString(3, salt);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Can't save credentials to data base");
        }
    }
}

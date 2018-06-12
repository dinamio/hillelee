package hibernate.dao;

import hibernate.entity.Answer;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ui.Question.QuestionAddServlet;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class DAOEntity<T, Id extends Serializable>{ //When: T is type of Entity and Id- type of ID
    //Session variables and methods
    private Session currentSession;
    private Transaction currentTransaction;


    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    public void closeCurrentSession() {
        currentSession.close();
    }
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    //Session variables and methods
    public void persist(T entity){
        getCurrentSession().save(entity);
    }
    public void update(T entity) {
        getCurrentSession().update(entity);
    }
    public T findById(Id id){
        T entity= (T) getCurrentSession().get(getGenericType(),id);
        return entity;
    }
    public void delete(T entity){
        getCurrentSession().delete(entity);
    }
    public List<T> findAll(){
        List<T> collection = (List<T>) getCurrentSession().createQuery("from "+getGenericType().getSimpleName()).list();
        return collection;
    }
    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }

    public Class getGenericType(){
        Class type= (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return type;
    }
}
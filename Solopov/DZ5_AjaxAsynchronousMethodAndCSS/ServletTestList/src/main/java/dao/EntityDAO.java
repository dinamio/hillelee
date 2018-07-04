package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

 abstract class EntityDAO<T, Id extends Serializable> {//Wnen: T- is type of Entity, iD- Type of ID// and DAOEntity- inheritor type of DAOEntity
     SessionFactory sessionFactory;
    final Session session;

     @Autowired
     public EntityDAO(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
         this.session = sessionFactory.openSession();

     }

     public void persist(T entity) {
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        session.flush();
        transaction.commit();
    }

    public void update(T entity) {
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        session.flush();
        transaction.commit();
    }

    public T findById(Id id) {
        Transaction transaction = session.beginTransaction();
        T entity= (T) session.get(getGenericType(),id);
        session.flush();
        transaction.commit();
        return  entity;
    }

    public void delete(Id id) {
        Transaction transaction = session.beginTransaction();
        T entity = (T) findById(id);
        session.delete(entity);
        session.flush();
        transaction.commit();
    }

    public List<T> findAll() {
        Transaction transaction = session.beginTransaction();
        List<T> collection = session.createQuery("from "+getGenericType().getSimpleName()).list();
        session.flush();
        transaction.commit();
        return collection;
    }
    public void deleteAll() {
        Transaction transaction = session.beginTransaction();
        List<T> entityList = findAll();
        for (T entity : entityList) {
            session.delete(entity);
        }
        session.flush();
        transaction.commit();
    }


    public Class getGenericType(){
        Class type= (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return type;
    }
}

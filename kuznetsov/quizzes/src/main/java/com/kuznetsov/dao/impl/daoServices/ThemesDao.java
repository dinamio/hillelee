package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.ThemesEntity;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class ThemesDao {
    public ThemesEntity getThemeFromDb(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        ThemesEntity themesEntity = session.get(ThemesEntity.class, id);


        return themesEntity;
    }

    public Integer saveThemeToBd(ThemesEntity themesEntity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(themesEntity);
        transaction.commit();

        return themesEntity.getId();
    }
}

package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Themes;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class ThemesDao {
    public Themes getThemeFromDb(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Themes themes = session.get(Themes.class, id);

        return themes;
    }

    public Integer saveThemeToBd(Themes themes) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(themes);
        transaction.commit();

        return themes.getId();
    }
}

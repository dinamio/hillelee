package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Themes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ThemesDao {
    private final Session session;

@Autowired
    public ThemesDao(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public Themes getThemeFromDb(Integer id) {

        return session.get(Themes.class, id);
    }

    public Integer saveThemeToBd(Themes themes) {

        Transaction transaction = session.beginTransaction();
        session.save(themes);
        transaction.commit();

        return themes.getId();
    }
}

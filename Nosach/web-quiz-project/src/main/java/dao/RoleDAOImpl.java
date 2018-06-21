package dao;

import entity.Role;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
@Qualifier("roleDao")
public class RoleDAOImpl implements RoleDAO{

    final Session session;

    @Autowired
    public RoleDAOImpl(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    @Override
    public Role getRole(String roleName) {
        Query query = session.createQuery("from Role where role=:roleName");
        query.setParameter("roleName", roleName);
        Role role = null;
        try {
            role = (Role) query.getSingleResult();
        }catch(NoResultException ex){
            ex.printStackTrace();
        }
        return role;
    }
}

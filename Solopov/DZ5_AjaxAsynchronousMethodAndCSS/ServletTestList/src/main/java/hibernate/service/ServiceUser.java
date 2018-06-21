package hibernate.service;

import hibernate.dao.DAOEntity;
import hibernate.dao.UserDAO;
import hibernate.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser extends ServiceEntity<User,Integer>{
    @Override
    DAOEntity getDaoEntity() {
        return new UserDAO();
    }
    public User findByLogin(String login) {
        daoEntity.openCurrentSession();
       Criteria criteria = daoEntity.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        User result = (User)criteria.uniqueResult();
        daoEntity.closeCurrentSession();

        return result;
    }
}
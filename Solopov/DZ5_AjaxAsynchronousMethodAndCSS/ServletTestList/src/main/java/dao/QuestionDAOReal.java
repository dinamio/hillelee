package dao;

import model.Question;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuestionDAOReal extends EntityDAO<Question,Integer> {


    public QuestionDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

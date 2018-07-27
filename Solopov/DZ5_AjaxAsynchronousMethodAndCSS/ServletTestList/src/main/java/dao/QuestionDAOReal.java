package dao;

import model.Question;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class QuestionDAOReal extends EntityDAO<Question,Integer> {


    public QuestionDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

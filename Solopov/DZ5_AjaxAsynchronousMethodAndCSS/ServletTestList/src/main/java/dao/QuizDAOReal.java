package dao;

import model.Quiz;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class QuizDAOReal extends EntityDAO<Quiz,Integer> {


    public QuizDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

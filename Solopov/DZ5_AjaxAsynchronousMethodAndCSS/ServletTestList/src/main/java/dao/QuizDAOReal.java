package dao;

import model.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuizDAOReal extends EntityDAO<Quiz,Integer> {


    public QuizDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

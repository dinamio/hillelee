package dao;

import model.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class AnswerDAOReal extends EntityDAO<Answer, Integer> {

    public AnswerDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

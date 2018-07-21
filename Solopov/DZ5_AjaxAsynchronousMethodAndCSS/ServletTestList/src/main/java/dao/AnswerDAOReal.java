package dao;

import model.Answer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class AnswerDAOReal extends EntityDAO<Answer, Integer> {
    public AnswerDAOReal(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

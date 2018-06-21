package hibernate.service;

import hibernate.dao.AnswerDAO;
import hibernate.dao.DAOEntity;
import hibernate.dao.QuestionDAO;
import hibernate.dao.QuizDAO;
import hibernate.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceQuestion extends ServiceEntity<Question,Integer> {
    @Override
    DAOEntity getDaoEntity() {
        return new QuestionDAO();
    }
}

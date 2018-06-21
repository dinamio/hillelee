package hibernate.service;

import hibernate.dao.AnswerDAO;
import hibernate.dao.DAOEntity;
import hibernate.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAnswer extends ServiceEntity<Answer, Integer> {
    @Override
    DAOEntity getDaoEntity() {
       return new AnswerDAO();
    }
}

package hibernate.service;

import hibernate.dao.DAOEntity;
import hibernate.dao.QuizDAO;
import hibernate.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceQuiz extends ServiceEntity<Quiz,Integer> {

    @Override
    DAOEntity getDaoEntity() {
      return new QuizDAO();
    }
}

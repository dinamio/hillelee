package Services;

import Entities.QuizTopic;
import Entities.Registration;
import dao.QuizDao;
import dao.impl.QuizDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class QuizService {

    /* TODO DAFAQ is this and why isn't it working with simple Autowired quizDAO? */
    private QuizDao quizDao;

    @Autowired
    public QuizService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    public List<QuizTopic> getListQuiz() {
        List<QuizTopic> result;
        result = quizDao.getAllQuizzes();
        return result;
    }

    public void addQuiz(QuizTopic quizTopic){
        quizDao.insertQuiz(quizTopic);
    }

    public void addQuiz(QuizTopic quizTopic, Registration currentUser){
        quizDao.insertQuiz(quizTopic, currentUser);
    }

    public static void deleteByIdNoLambda(List<QuizTopic> listQuiz, int id) {
        Iterator<QuizTopic> iterator = listQuiz.iterator();
        while (iterator.hasNext()) {
            QuizTopic quizTopic = iterator.next();
            if (quizTopic.getId() == id) {
                iterator.remove();
            }
        }
    }

    /* Same thing but with lambda */
    public static void deleteById(List<QuizTopic> listQuiz, int id) {
        listQuiz.removeIf(quizTopic -> quizTopic.getId() == id);
    }

    public void deleteById(Integer id){
        quizDao.deleteById(id);
    }

}

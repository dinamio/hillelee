package borysov.service;

import borysov.dao.QuizDao;
import borysov.entity.Answer;
import borysov.entity.Quiz;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class QuizService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class);
    @Autowired
    @Qualifier("hibernate")
    private QuizDao quizDao;

    public List<Quiz> getListOfQuizzes() {

        return quizDao.getQuizzesAsAList();
    }


    public void addQuiz(Quiz quiz){

        try {
            quizDao.addQuizToDB(quiz);
        } catch (SQLException e) {
            LOGGER.error("addQuiz SQL Exception",e);
        }
    }

    public void removeQuizById(int id) {
        quizDao.deleteQuizFromDBById(id);
    }

    public void addQuestionAndAnswers(Integer quizId, String quationText, List<Answer> answersList) {
        quizDao.addQuestionToDB(quizId,quationText);
        Integer questionId =  quizDao.getQuestionIdFromDB(quizId,quationText);
        quizDao.addAnswersToDB(questionId,answersList);


    }

}

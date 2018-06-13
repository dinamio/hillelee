package borysov.dao.impl;

import borysov.dao.QuizDao;
import borysov.entity.Answer;
import borysov.entity.Question;
import borysov.entity.Quiz;
import borysov.entity.User;
import borysov.service.UserService;
import borysov.utility.HibernateUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
@Qualifier("hibernate")
public class QuizHibernateDaoImpl implements QuizDao {
    private static final Logger LOGGER = Logger.getLogger(QuizHibernateDaoImpl.class);

    public List<Quiz> getQuizzesAsAList() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Quiz");
        List<Quiz> listOfQuizzes = query.list();
        session.flush();
        transaction.commit();
        return listOfQuizzes;

    }

    public void addQuizToDB(Quiz quiz) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(quiz);
        session.flush();
        transaction.commit();
    }

    public void deleteQuizFromDBById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Quiz where id=:quizId");
        query.setParameter("quizId", id);
        query.executeUpdate();
        session.flush();
        transaction.commit();
    }

    public void addQuestionToDB(Integer quizId, String questionText) {

        Question question = new Question();
        question.setIdOfQuiz(quizId);
        question.setTextOfQuestion(questionText);

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.flush();
        transaction.commit();
    }

    public Integer getQuestionIdFromDB(Integer quizId, String questionText) {
        System.out.println(quizId+ " " + questionText);
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = (Query) session.createQuery("select id from Question where idOfQuiz=:qId and textOfQuestion=:text");
        query.setParameter("qId", quizId);
        query.setParameter("text", questionText).uniqueResult();


        Integer questionId = null;
        try {
            questionId = (Integer) query.getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return questionId;
    }

    public void addAnswersToDB(Integer questionId, List<Answer> answersList) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int i = 0;
        while (i < answersList.size()) {
            Answer answer = answersList.get(i);
            answer.setIdOfQuestion(questionId);
            session.save(answer);
            i++;
        }
        session.flush();
        transaction.commit();
    }
}
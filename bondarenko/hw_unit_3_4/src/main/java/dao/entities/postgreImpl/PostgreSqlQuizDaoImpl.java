package dao.entities.postgreImpl;


import dao.Entity;
import dao.entities.QuizDao;
import dao.Vendor;
import model.Quiz;

public class PostgreSqlQuizDaoImpl extends QuizDao {

    public PostgreSqlQuizDaoImpl() {
        super(Vendor.PostgreSQL, Entity.QUIZ);
    }
}

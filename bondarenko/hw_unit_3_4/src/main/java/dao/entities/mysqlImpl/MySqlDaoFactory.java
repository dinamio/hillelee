package dao.entities.mysqlImpl;

import dao.DaoAbstractFactory;
import dao.entities.QuizDao;
import dao.entities.postgreImpl.PostgreSqlQuizDaoImpl;

public class MySqlDaoFactory implements DaoAbstractFactory {
    @Override
    public QuizDao createQuizDao() {
        return new PostgreSqlQuizDaoImpl();
    }
}

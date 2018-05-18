package dao.entities.postgreImpl;

import dao.entities.QuizDao;
import dao.DaoAbstractFactory;

public class PostgreSqlDaoFactory implements DaoAbstractFactory {
    @Override
    public QuizDao createQuizDao() {
        return new PostgreSqlQuizDaoImpl();
    }
}

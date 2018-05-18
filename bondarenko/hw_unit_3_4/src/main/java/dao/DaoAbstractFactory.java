package dao;

import dao.entities.QuizDao;

public interface DaoAbstractFactory {

    QuizDao createQuizDao();
}

package dao;

import dao.entities.QuizDao;

public class DaoFactory {

    public static QuizDao createQuizDao(DaoAbstractFactory factory){
        return factory.createQuizDao();
    }
}

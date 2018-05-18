package dao.entities.mysqlImpl;


import dao.Entity;
import dao.Vendor;
import dao.entities.QuizDao;

public class MySqlQuizDaoImpl extends QuizDao {

    public MySqlQuizDaoImpl(Vendor vendor, Entity entity) {
        super(Vendor.MySQL, Entity.QUIZ);
    }
}
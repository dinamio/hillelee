package service;

import entity.Registration;
import dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RegistrationService {

    private final UsersDao usersDao;

    @Autowired
    public RegistrationService(@Qualifier("hibernate") UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public  boolean checkLoginIsUntaken(String login) {
        List<Registration> listRegistration = usersDao.getAllUsers();
        boolean bool = true;
        Registration current = new Registration(login, "somePasswordHere");
        for (Registration inHolder : listRegistration) {
            if (Objects.equals(current.getLogin(), inHolder.getLogin())) {
                bool = false;
            }
        }
        return bool;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        List<Registration> listRegistration = usersDao.getAllUsers();
        Registration curB = new Registration(login, password);
        for (Registration regB : listRegistration) {
            if (regB.equals(curB)) {
                return true;
            }
        }
        return false;
    }

    public  void addUser(Registration user){
        usersDao.insertUser(user);
    }
}

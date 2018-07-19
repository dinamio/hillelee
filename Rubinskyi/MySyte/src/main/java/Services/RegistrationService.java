package Services;

import Entities.Registration;
import dao.UsersDao;
import dao.impl.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RegistrationService {
    @Autowired
    private UsersDao usersDao;

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

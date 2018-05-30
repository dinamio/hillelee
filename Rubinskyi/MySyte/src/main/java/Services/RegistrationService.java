package Services;

import Entities.RegistrationBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistrationService {
    private static List<RegistrationBean> listRegistration = new ArrayList<>();

    public static List<RegistrationBean> getListRegistration() {
        return listRegistration;
    }

    public static boolean checkLoginIsUntaken(String login) {
        boolean bool = true;
        RegistrationBean current = new RegistrationBean(login, "somePasswordHere");
        for (RegistrationBean inHolder : listRegistration) {
            if (Objects.equals(current.getLogin(), inHolder.getLogin())) {
                bool = false;
            }
        }
        return bool;
    }

    public static boolean checkLoginAndPassword(String login, String password) {
        RegistrationBean curB = new RegistrationBean(login, password);
        for (RegistrationBean regB : listRegistration) {
            if (regB.equals(curB)) {
                return true;
            }
        }
        return false;
    }
}

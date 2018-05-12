package Services;

import Entities.RegistrationBean;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistrationService {
    private static List<RegistrationBean> listRegistration = new ArrayList<>();

    public static List<RegistrationBean> getListRegistration() {
        return listRegistration;
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

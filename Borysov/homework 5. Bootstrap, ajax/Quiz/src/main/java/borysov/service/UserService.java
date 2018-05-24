package borysov.service;

import borysov.dao.UserDao;
import borysov.dao.impl.UserDaoImpl;
import borysov.entity.*;
import borysov.exception.DAOException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public String MD5Hashing(String md5) {
        System.out.println(md5);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            System.out.println(sb.toString());
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    public User getUserByLoginAndPass(String login, String password) {
       String hashPassword = MD5Hashing(password);
        try {
            return userDao.getUserFromDB(login, hashPassword);
        } catch (SQLException e) {
           LOGGER.error("getUserByLoginAndPass SQL Exception",e);
        }

        return null;
    }

    public void registerUser(User newUser) {
        String hashPassword = MD5Hashing(newUser.getPassword());
        newUser.setPassword(hashPassword);
        userDao.addNewUserToDB(newUser);
    }
}

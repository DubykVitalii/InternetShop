package main.java.service;

import main.java.dao.UserDao;
import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.model.User;

// TODO: make it singleton
public class UserService {
    private static UserService userService;
    private final UserDao userDao = UserInMemoryDao.getEntity();

    private UserService() {
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    /**
     * Used to login a user
     *
     * @param username user name
     * @param password user password
     * @return outcome of login - success or not
     */
    public boolean login(String username, String password) {
        User user = UserInMemoryDao.getEntity().getUserByUsername(username);
        return user.getPassword().equals(password);
    }

    /**
     * Actice user
     *
     * @param username user name
     * @return boolean isActice user;
     */

    public boolean isActive(String username) {
        User user = UserInMemoryDao.getEntity().getUserByUsername(username);
        return user.isActive();
    }

}

package main.java.service;

import main.java.dao.UserDao;
import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.model.User;

// TODO: make it singleton
public class UserService {

    private final UserDao userDao = UserInMemoryDao.getEntity();

    /**
     * Used to login a user
     *
     * @param username user name
     * @param password user password
     * @return outcome of login - success or not
     */
    public boolean login(String username, String password) {
        return true;
    }

    public User signUp(final String username, final String password) {
//        1. check if username is available
//        1.1. if username is taken throw UsernameIsTakenException()
//        2. new User(username, password)
//        3. userDao.saveUser(newUser)
//        4. return user
        return null;
    }
}

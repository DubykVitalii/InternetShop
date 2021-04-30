package main.java.service;

import main.java.dao.UserDao;
import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.model.User;

import java.util.List;

public class UserService {
    private static UserService userService;
    private final UserDao userDao = UserInMemoryDao.getEntity();

    private UserService() {
    }

    public static UserService getInstance() {
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

    /**
     * Get user by id
     *
     * @return found user by id
     */
    public User getUserById(int userId) {
        return UserInMemoryDao.getEntity().getUserById(userId);
    }

    /**
     * Remove user in memory dao
     */
    public void removeUser(int userId) {
        UserInMemoryDao.getEntity().removeUser(userId);
    }


    /**
     * Get user by username
     *
     * @return found user by username
     */
    public User getUserByUsername(String username) {
      return UserInMemoryDao.getEntity().getUserByUsername(username);
    }

    /**
     * Get all users
     *
     * @return all users
     */
    public List<User> getAllUsers() {
        return UserInMemoryDao.getEntity().getAllUsers();
    }

    /**
     * Save new user
     */
    public void saveUser(User user) {
        UserInMemoryDao.getEntity().saveUser(user);
    }

}

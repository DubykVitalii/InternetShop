package main.java.dao;

import main.java.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(int userId);

    void removeUser(int userId);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}



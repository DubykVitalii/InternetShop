package main.java.dao.impl;

import main.java.dao.DB.UserDB;
import main.java.dao.UserDao;
import main.java.model.UserModel;

import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao<UserModel> {
    UserDB userDB = new UserDB();

    @Override
    public void saveUser(UserModel userModel) {
        if (isUserInDatabase(userModel.getUserID())) {
            System.out.println("User already exists in the database.");
        } else {
            try {
                userDB.getUserDB().add(userModel);
            } catch (Exception e) {
                System.out.println("Problem with adding a User to the database.");
            }
        }
    }

    @Override
    public UserModel getUserById(long userID) {
        UserModel userModelRez = null;
        if (isUserInDatabase(userID)) {
            try {
                userModelRez = userDB.getUserDB().stream()
                        .filter(userModel -> userModel.getUserID() == userID)
                        .collect(Collectors.toList()).get(0);
            } catch (Exception e) {
                System.out.printf("Problem with getting a User with id = %s from the database", userID);
            }
        } else {
            System.out.printf("User with id = %s is not found.", userID);
        }
        return userModelRez;
    }


    @Override
    public void removeUser(long userID) {
        if (isUserInDatabase(userID)) {
            boolean userIsRemoved = false;
            try {
                userIsRemoved = userDB.getUserDB().remove(getUserById(userID));
            } catch (Exception e) {
                System.out.printf("Problem during removing a user with id = %s from the database", userID);
            }
            if (userIsRemoved) {
                System.out.printf("User with id = %s was removed.", userID);
            }
        } else {
            System.out.printf("User with id = %s not found.", userID);
        }
    }

    @Override
    public UserModel getUserByUsername(String userName) {
        return null;
    }


    private boolean isUserInDatabase(long userID) {
        return userDB.getUserDB().stream().anyMatch(userModel -> userModel.getUserID() == userID);
    }

}
package main.java.dao.inmemorydb;

import main.java.dao.UserDao;
import main.java.model.User;
import main.java.model.UserRole;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserInMemoryDao implements UserDao {

    private final Map<String, User> users = new HashMap<>();

    private static UserDao entity;

    public static UserDao getEntity() {
        if (entity == null) {
            entity = new UserInMemoryDao();
        }
        return entity;
    }

    private UserInMemoryDao() {
        User admin = new User("admin", "admin", UserRole.ADMIN, true, "Admin");
        users.put(admin.getUserId(), admin);
    }

    /**
     * @param user
     * save user to DB
     */
    @Override
    public void saveUser(User user) {
        users.put(user.getUserId(), user);
    }

    /**
     * @return user or null if there is no user with a given userId
     */
    @Override
    public User getUserById(String userId) {
        return users.get(userId);
    }

    /**
     * @param userId
     * remove user from db by userId
     */
    @Override
    public void removeUser(String userId) {
        users.remove(userId);
    }

    /**
     * @param username
     * @return user or null if there is no user with a given username
     */
    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = users.values().stream().filter(el -> el.getUsername().equals(username)).findFirst();
        boolean empty = user.isEmpty();
        return empty ? null : user.get();
    }
}

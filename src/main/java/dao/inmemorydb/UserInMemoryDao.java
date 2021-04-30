package main.java.dao.inmemorydb;

import main.java.dao.UserDao;
import main.java.model.User;
import main.java.model.UserRole;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInMemoryDao implements UserDao {

    private final Set<User> users = new HashSet<>();

    private static UserDao entity;

    public static UserDao getEntity() {
        if (entity == null) {
            entity = new UserInMemoryDao();
        }
        return entity;
    }

    private UserInMemoryDao() {
        User admin = new User("admin", "admin", UserRole.ADMIN, true, "Admin");
        User user = new User("user", "user", UserRole.USER, true, "user");
        User user1 = new User("testuser", "testuser", UserRole.USER, true, "user");
        users.add(admin);
        users.add(user);
        users.add(user1);
    }

    /**
     * Save new user
     */
    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    /**
     * Get user by id
     *
     * @return found user by id
     */
    @Override
    public User getUserById(int userId) {
        User user = null;
        for (User findUser : users) {
            if (findUser.getUserId() == (userId)) {
                user = findUser;
            }
        }
        return user;
    }

    /**
     * Remove user in memory dao
     */
    @Override
    public void removeUser(int userId) {
        users.remove(getUserById(userId));
    }


    /**
     * Get user by username
     *
     * @return found user by username
     */
    @Override
    public User getUserByUsername(String username) {
        User user = null;
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                user = u;
            }
        }
        return user;
    }

    /**
     * Get all users
     *
     * @return all users
     */
    @Override
    public List<User> getAllUsers() {
        return List.copyOf(users);
    }
}

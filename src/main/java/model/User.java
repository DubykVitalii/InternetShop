package main.java.model;

import java.util.Objects;

public class User {
    private static int count = 0;

    private final int userId;
    private String username;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private String name;

    public User(String username, String password) {
        this.userId = count++;
        this.username = username;
        this.password = password;
        this.userRole = UserRole.USER;
        this.isActive = true;
        this.name = username;
    }

    public User(String username, String password, UserRole userRole, boolean isActive, String name) {
        this.userId = count++;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.isActive = true;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean isAdmin() {
        return userRole == UserRole.ADMIN;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    // User password not showed
    @Override
    public String toString() {
        return "\nUser ID:" + userId + "\t" +
                ", name:" + name + "\t" +
                ", username:" + username + "\t" +
                ", User Roles:" + getUserRole() +
                ", Active:" + isActive;
    }


    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

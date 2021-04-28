package main.java.model;

import java.util.Objects;
import java.util.UUID;

public class User {

    private final String userId;
    private String username;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private String name;

    public User(String username, String password) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.userRole = UserRole.USER;
        this.isActive = true;
        this.name = "";
    }

    public User(String username, String password, UserRole userRole, boolean isActive, String name) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.isActive = isActive;
        this.name = name;
    }

    public String getUserId() {
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
        return  "  UserName = '" + username + '\'' +
                ", userRole = " + getUserRole() +
                ", active = " + isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}

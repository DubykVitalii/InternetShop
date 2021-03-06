package main.java.view;

import main.java.Session;
import main.java.dao.inmemorydb.UserInMemoryDao;
import main.java.model.User;
import main.java.model.UserRole;
import main.java.service.UserService;
import main.java.view.admin.AdminMainMenu;
import main.java.view.user.UserMainMenu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private final String[] items = {"1. Login", "2. Register", "0. Exit"};
    private Scanner scannerInt;
    private Scanner scannerString;

    /**
     * Login menu
     *
     * items  - items login menu
     * choice - choice user (1,2 or 0)
     *               if choice != (1,2 or 0 ) default --> show();
     */
    @Override
    public void show() {
        showItems(items);
        scannerInt = new Scanner(System.in);
        scannerString = new Scanner(System.in);
        while (true) {
            int choice = scannerInt.nextInt();
            switch (choice) {
                case 1:
                    loginSubMenu(scannerInt);
                    break;
                case 2:
                    registerSubMenu(scannerInt);
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.err.println("Incorrect choice");
                    show();
            }
        }
    }

    /**
     * Login menu
     *
     * username - username user
     * password - password user
     *                 if username or password incorrect
     *                 then sent message -> ("Username or password are incorrect. Please try again...")
     *                 if user locked then sent message -> ("User is blocked...")
     */
    private void loginSubMenu(Scanner scannerString) {
        System.out.println("input username:");
        String username = scannerString.next();
        System.out.println("input password:");
        String password = scannerString.next();
        try {
            if (UserService.getInstance().login(username, password) && UserService.getInstance().isActive(username)) {
                Session.loginUser(UserInMemoryDao.getEntity().getUserByUsername(username));
            } else if (!UserService.getInstance().login(username, password)) {
                System.err.println("Username or password are incorrect. Please try again...");
                loginSubMenu(scannerString);
            } else if (!UserService.getInstance().isActive(username)) {
                System.err.println("User is blocked...");
                show();
            }
        } catch (NullPointerException e) {
            System.err.println("Username or password are incorrect. Please try again...");
            loginSubMenu(scannerString);
        }
        try {
            if (Session.getCurrentUser().getUserRole().equals(UserRole.USER)) {
                new UserMainMenu().show();
            } else {
                new AdminMainMenu().show();
            }
        } catch (NullPointerException e) {
            System.err.println("Username or password are incorrect. Please try again...");
            loginSubMenu(scannerString);
        }
    }

    /**
     * Register menu
     *
     * username - username user
     * password - password user
     *                 if username is already exits then sent is message -> ("Username is already exists")
     */
    private void registerSubMenu(Scanner scannerString) {
        System.out.println("Create username:");
        String username = scannerString.next();
        if (UserService.getInstance().getUserByUsername(username) == null) {
            System.out.println("Create password:");
            String password = scannerString.next();
            UserService.getInstance().saveUser(new User(username, password));
        } else {
            System.err.println("Username is already exists...");
            registerSubMenu(scannerString);
        }
        System.out.println("You have been successfully registered...");

        show();
    }

    /**
     * Exit program
     */
    @Override
    public void exit() {
        System.exit(0);
    }
}
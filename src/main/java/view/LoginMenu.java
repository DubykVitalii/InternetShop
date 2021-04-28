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
    private Scanner scanner;

    /**
     * Login menu
     *
     * @param items  - items login menu
     * @param choice - choice user (1,2 or 0)
     *               if choice != (1,2 or 0 ) default --> show();
     */

    @Override
    public void show() {
        showItems(items);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loginSubMenu(scanner);
                    break;
                case 2:
                    registerSubMenu(scanner);
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
     * @param username - username user
     * @param password - password user
     *                 if username or password incorrect
     *                 then sent message -> ("Username or password are incorrect. Please try again...")
     *                 if user locked then sent message -> ("User is blocked...")
     */

    private void loginSubMenu(Scanner scanner) {
        System.out.println("input username:");
        String username = scanner.next();

        System.out.println("input password:");
        String password = scanner.next();


        try {
            if (UserService.getUserService().login(username, password) && UserService.getUserService().isActive(username)) {
                Session.loginUser(UserInMemoryDao.getEntity().getUserByUsername(username));
            } else if (!UserService.getUserService().login(username, password)) {
                System.err.println("Username or password are incorrect. Please try again...");
                loginSubMenu(scanner);
            } else if (!UserService.getUserService().isActive(username)) {
                System.err.println("User is blocked...");
                show();
            }
        } catch (NullPointerException e) {
            System.err.println("Username or password are incorrect. Please try again...");
            loginSubMenu(scanner);
        }

        try {
            if (Session.getCurrentUser().getUserRole().equals(UserRole.USER)) {
                new UserMainMenu().show();
            } else {
                new AdminMainMenu().show();
            }

        } catch (NullPointerException e) {
            System.err.println("Username or password are incorrect. Please try again...");
            loginSubMenu(scanner);
        }


    }

    /**
     * Register menu
     *
     * @param username - username user
     * @param password - password user
     *                 if username is already exits then sent is message -> ("Username is already exists")
     */

    private void registerSubMenu(Scanner scanner) {

        System.out.println("Create login:");
        String username = scanner.next();


        if (UserInMemoryDao.getEntity().getUserByUsername(username) == null) {
            System.out.println("Create password:");
            String password = scanner.next();
            UserInMemoryDao.getEntity().saveUser(new User(username, password));
        } else {
            System.err.println("Username is already exists");
            registerSubMenu(scanner);
        }
        System.out.println("You have been successfully registered");

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
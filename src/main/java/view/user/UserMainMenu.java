package main.java.view.user;

import main.java.Session;
import main.java.view.LoginMenu;
import main.java.view.Menu;

import java.util.Scanner;

public class UserMainMenu implements Menu {
    private Scanner scanner;
    private final String[] itemsMenuUser = {"1. Product menu", "2. My order","3. PM Chat", "0. Exit"};

    /**
     * Main menu user
     *
     * @param itemsMenuUser - items menu user
     * @param choice        - choice user (1,2 or 0)
     *                      if choice != (1,2 or 0 ) default --> show();
     *                      if choice 1 show user product menu
     *                      if choice 2 show order menu
     *                      if choice 0 exit user main menu
     */

    @Override
    public void show() {
        showItems(itemsMenuUser);
        scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    new UserProductMenu().show();
                    break;
                case 2:
                    new UserOrderMenu().show();
                    break;
                case 3:
                    new UserPmChat().show();
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
     * Exit login menu
     * Logout user
     */

    @Override
    public void exit() {
        Session.logoutUser();
        new LoginMenu().show();
    }
}

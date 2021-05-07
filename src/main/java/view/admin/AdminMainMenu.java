package main.java.view.admin;


import main.java.Session;
import main.java.view.LoginMenu;
import main.java.view.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMainMenu implements Menu {
    private Scanner scanner;

    private final String[] itemsMenuAdmin = {"1. User menu", "2. Order confirm", "3. Product menu", "4. PM chat", "0. Exit"};

    /**
     * Admin main menu
     *
     * itemsMenuAdmin - items menu admin
     * choice         - choice user (1,2,3 or 0)
     *                       <p>
     *                       if choice 1 show Admin User Menu
     *                       if choice 2 show Admin Order Menu
     *                       if choice 3 show Admin Product Menu
     *                       if choice 0 exit login menu
     */
    public void show(){
        showItems(itemsMenuAdmin);
        scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    new AdminUserMenu().show();
                    break;
                case 2:
                    new AdminOrderMenu().show();
                    break;
                case 3:
                    new AdminProductMenu().show();
                    break;
                case 4:
                    new AdminPmChat().show();
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

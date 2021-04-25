package main.java.view;

import main.java.exceptions.WrongCredentialsException;
import main.java.service.UserService;
import main.java.view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    private UserService userService;
    private final String[] items = {"1. Login", "2. Register"};
    private Scanner scanner;

    @Override
    public void show() {
        showItems(items);
        System.out.println("0. Exit");

        scanner = new Scanner(System.in);


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
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void loginSubMenu(Scanner scanner) {
        System.out.println("input username:");
        String username = scanner.nextLine();

        System.out.println("input password:");
        String password = scanner.nextLine();

        try {
            userService.login(username, password);

//        } catch (WrongCredentialsException e) {
//            // System.oty.println("Username or password are incorrect. Please try again...");
//            // show login view
//        } catch (Exception e2) {

        } catch (Exception e3) {

        } finally {

        }
        // show main menu
    }

    private void registerSubMenu(Scanner scanner) {

        System.out.println("-------------");

        System.out.println("Create login:");
        scanner.nextLine();
        String login = scanner.nextLine();

        if (false) {

            System.out.println("Create password:");
            String password = scanner.nextLine();
        } else {
            System.out.println("username is already exists");
            registerSubMenu(scanner);
        }

//        System.out.println("Create password:");
//        String password = scanner.nextLine();

        System.out.println("You have been successfully registered");
        show(); //todo add impl
    }
}
package main.java.view.user;

import main.java.service.OrderService;
import main.java.view.Menu;

import java.util.Scanner;

public class UserOrderMenu implements Menu {
    private Scanner scanner;
    private final String[] itemsOrderUser = {"1. My orders checkout", "0. Exit User Menu"};


    /**
     * Order menu user
     *
     * @param itemsOrderUser - items order menu user
     * @param choice         - choice user (1 or 0)
     *                       if choice != (1 or 0) default --> show();
     *                       if choice 1 show orders user
     *                       if choice 0 exit user main menu
     */
    @Override
    public void show() {
        showItems(itemsOrderUser);
        scanner = new Scanner(System.in);
        while (true) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showEntity(OrderService.getOrderService().ordersUser());
                    show();
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
     * Exit user menu
     */
    @Override
    public void exit() {
        new UserMainMenu().show();
    }
}

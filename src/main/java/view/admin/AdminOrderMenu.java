package main.java.view.admin;

import main.java.dao.inmemorydb.OrderInMemoryDao;
import main.java.model.Order;
import main.java.service.OrderService;
import main.java.view.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminOrderMenu implements Menu {
    private Scanner scanner;

    private final String[] itemsOrderMenuAdmin = {"1. Confirm/unconfirmed order","2. Show all orders", "0 Exit Admin Menu"};

    /**
     * Admin order menu
     *
     * itemsOrderMenuAdmin - items order menu admin
     * choice              - choice user (1,2,3 or 0)
     *                            <p>
     *                            if choice 1 confirm/unconfirmed order
     *                            if choice 2 show all orders user and confirm/unconfirmed order
     *                            if choice 0 exit admin main menu
     */
    @Override
    public void show() {
        showItems(itemsOrderMenuAdmin);
        scanner = new Scanner(System.in);
        while (true) {
                int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showEntity(OrderService.getInstance().getAllOrders().toString());
                    System.out.println("Enter ID order");
                    int choiceIdProduct = scanner.nextInt();
                    System.out.println("1. Confirm order");
                    System.out.println("2. Unconfirmed order");
                    int choiceConfirmOrUnconfirmed = scanner.nextInt();
                    if (choiceConfirmOrUnconfirmed == 1) {
                        OrderService.getInstance().orderConfirmed(OrderService.getInstance().getOrderById(choiceIdProduct));
                        show();
                    } else if (choiceConfirmOrUnconfirmed == 2) {
                        OrderService.getInstance().orderCancelledAsAdmin(OrderService.getInstance().getOrderById(choiceIdProduct));
                        show();
                    } else {
                        System.err.println("Incorrect choice");
                        show();
                    }
                    break;
                case 2:
                    showEntity(OrderService.getInstance().getAllOrders().toString());
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

    @Override
    public void exit() {
        new AdminMainMenu().show();
    }
}
